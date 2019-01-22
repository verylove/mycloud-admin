package com.mycloud.admin.feign;

import com.mycloud.admin.feign.fallback.UserClientFallBack;
import com.mycloud.common.model.AuthAccount;
import com.mycloud.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server.feign
 * @Description: UserClient
 * @date 2018/4/18 11:05
 */
@FeignClient(name = "MYCLOUD-USER",fallback = UserClientFallBack.class)
public interface UserClient {

    @PostMapping(value = "/account/getUserByUsername",produces = "application/json;charset=UTF-8")
    Result<AuthAccount> queryByName(@RequestParam("username") String username);
    @PostMapping(value = "/account/roles",produces = "application/json;charset=UTF-8")
    Result<List<String>> getAuthRolesByRequestUrl(@RequestParam("url") String url);
}
