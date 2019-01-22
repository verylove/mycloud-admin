package com.mycloud.admin.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/pujiaolin/article/details/73928491
 */
@Slf4j
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        if(authentication == null){
            throw new AccessDeniedException("权限被拒绝!");
        }
        //当前用户拥有的角色集合
        List<String> roleCodes = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        //访问路径所需要的角色集合
        List<String> configRoleCodes = collection.stream().map(ConfigAttribute::getAttribute).collect(Collectors.toList());

        if(configRoleCodes.contains("ROLE_DENIED")){
            System.out.println("========权限被拒绝==========");
            throw new AccessDeniedException("权限被拒绝!");
        }

        for (String roleCode : roleCodes){
            if(configRoleCodes.contains(roleCode)){
                return;
            }
        }
        throw new AccessDeniedException("权限被拒绝!");
    }
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
