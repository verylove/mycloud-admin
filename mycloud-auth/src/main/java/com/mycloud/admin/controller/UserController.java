package com.mycloud.admin.controller;

import com.mycloud.common.enums.ResultEnum;
import com.mycloud.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server.controller
 * @Description: 返回用户信息
 * @date 2018/4/13 13:58
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/oauth/remove_token")
    public Result removeToken(@RequestParam("token") String token) {

        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            tokenStore.removeAccessToken(accessToken);
        } else {
            return Result.returnFail(ResultEnum.TOKEN_MISS);
        }

        return Result.returnSuccess();
    }

}
