package com.mycloud.admin.feign.fallback;

import com.mycloud.admin.feign.UserClient;
import com.mycloud.common.model.AuthAccount;
import com.mycloud.common.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server.feign.fallback
 * @Description: UserClientFallBack
 * @date 2018/4/18 11:33
 */
@Component
public class UserClientFallBack implements UserClient {

    @Override
    public Result<AuthAccount> queryByName(String username) {
        return Result.returnFail();
    }

    @Override
    public Result<List<String>> getAuthRolesByRequestUrl(String url) {
        return Result.returnFail();
    }
}
