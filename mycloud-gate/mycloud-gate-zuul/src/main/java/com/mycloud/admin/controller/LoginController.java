package com.mycloud.admin.controller;
import com.mycloud.admin.feign.OAuth2ServerClient;
import com.mycloud.admin.feign.UserClient;
import com.mycloud.common.model.AuthAccount;
import com.mycloud.common.result.Result;
import com.mycloud.common.result.ResultEnum;
import com.mycloud.common.utils.BCryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Package com.mycloud.admin
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/5/4 10:26
 */
@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Resource
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Resource
    private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    @Resource
    private OAuth2ServerClient oAuth2ServerClient;

    @Resource
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    /**
     * 通过密码授权方式向授权服务器获取令牌
     *
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        log.debug("========>username"+username+"===password"+password);
        //验证用户名密码
        Result<AuthAccount> result = userClient.queryByName(username);
        if (!ResultEnum.SUCCESS.getCode().equals(result.getCode())) {
            //登录失败
            return Result.returnFail(ResultEnum.LOGIN_FAIL);
        }
        AuthAccount authAccount = result.getData();
        if(BCryptUtil.isMatch(password,authAccount.getPassword())){
            ResponseEntity<OAuth2AccessToken> responseEntity = getToken(username, password);
            if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
                DefaultOAuth2AccessToken body = (DefaultOAuth2AccessToken) responseEntity.getBody();
                Map<String, Object> map = body.getAdditionalInformation();
                return Result.returnSuccess(body.getValue());
            } else {
                return Result.returnFail(ResultEnum.LOGIN_FAIL);
            }
        }else {
            return Result.returnFail(ResultEnum.LOGIN_USER_ERR);
        }
    }

    @PostMapping("/logout")
    public Result exit(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String tokenValue = authHeader.replace("bearer", "").trim();
        Result result = oAuth2ServerClient.removeToken(tokenValue);
        if (!ResultEnum.SUCCESS.getCode().equals(result.getCode())) {
            return Result.returnFail(ResultEnum.LOGIN_FAIL);
        }

        return Result.returnSuccess("注销成功");
    }

    @PostMapping(value = "/hello")
    public Result hello() throws Exception {

        return Result.returnSuccess("hello");
    }

    public ResponseEntity<OAuth2AccessToken> getToken(String userName, String passWord) {
        //Http Basic 验证
        String clientAndSecret = oAuth2ClientProperties.getClientId() + ":" + oAuth2ClientProperties.getClientSecret();
        //这里需要注意为 Basic 而非 Bearer
        clientAndSecret = "Basic " + Base64.getEncoder().encodeToString(clientAndSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", clientAndSecret);
        //授权请求信息
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("username", Collections.singletonList(userName));
        map.put("password", Collections.singletonList(passWord));
        map.put("grant_type", Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));
        map.put("scope", oAuth2ProtectedResourceDetails.getScope());
        //HttpEntity
        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
        //获取 Token
        ResponseEntity<OAuth2AccessToken> exchange = restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST, httpEntity, OAuth2AccessToken.class);
        return exchange;
    }

}
