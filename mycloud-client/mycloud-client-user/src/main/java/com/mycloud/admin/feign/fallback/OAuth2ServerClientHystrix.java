package com.mycloud.admin.feign.fallback;

import com.mycloud.admin.feign.OAuth2ServerClient;
import com.mycloud.common.result.Result;
import org.springframework.stereotype.Component;

/**
 * @author huangqi
 * @Package com.mycloud.admin.feign.hystrix
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/28 14:19
 */
@Component
public class OAuth2ServerClientHystrix implements OAuth2ServerClient {
    @Override
    public Result removeToken(String token) {
        return Result.returnFail();
    }

}
