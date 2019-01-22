package com.mycloud.admin.config.security;

import com.mycloud.admin.feign.UserClient;
import com.mycloud.common.excepiton.GlobalException;
import com.mycloud.common.result.Result;
import com.mycloud.common.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UrlFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private UserClient userClient;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object; //当前请求对象
        if (isMatcherAllowedRequest(fi)) return null ; //return null 表示允许访问，不做拦截
        List<ConfigAttribute> configAttributes = getMatcherConfigAttribute(fi.getRequestUrl());
        return configAttributes; //返回当前路径所需角色，如果没有则拒绝访问
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class< ? > aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    /**
     * 获取当前路径所需要的角色
     * @param url 当前路径
     * @return 所需角色集合
     */
    private List<ConfigAttribute> getMatcherConfigAttribute(String url){
        //Result<List<String>> result = userClient.getAuthRolesByRequestUrl(url);
        List<String> list = new ArrayList<String>();
        list.add("ROLE_ADMIN");
        Result<List<String>> result = Result.returnSuccess(list);
        if(!result.getCode().equals("0000")){
            throw new GlobalException(ResultEnum.DATA_MISS);
        }
        list = result.getData();
        return list.size()==0?deniedRequest():list.stream()
                .map(role -> new SecurityConfig(role)).collect(Collectors.toList());
//        return authPermissionMapper.getAuthRolesByRequestUrl(url).stream()
//                .map(role -> new SecurityConfig(role)).collect(Collectors.toList());
    }

    /**<code></code>
     * 判断当前请求是否在允许请求的范围内
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi){
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
//        boolean matches = false;
//        AntPathRequestMatcher requestMatcher = null;
//        List<String> strings = allowedRequest();
//        for(String s : strings){
//            requestMatcher = new AntPathRequestMatcher(s);
//            if(requestMatcher.matches(fi.getHttpRequest())){
//                matches=true;
//                break;
//            }
//        }
//        return matches;
    }

    /**
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest(){
        return Arrays.asList("/auth/login","/auth/logout","/api-user/system/info","/webjars/**","/swagger-ui.html");
    }

    /**
     * @return 默认拒绝访问配置
     */
    private List<ConfigAttribute> deniedRequest(){
        return Collections.singletonList(new SecurityConfig("ROLE_DENIED"));
    }
}
