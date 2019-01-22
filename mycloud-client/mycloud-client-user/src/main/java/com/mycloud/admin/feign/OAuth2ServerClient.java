package com.mycloud.admin.feign;

import com.mycloud.admin.feign.fallback.OAuth2ServerClientHystrix;
import com.mycloud.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangqi
 * @Package com.mycloud.admin.feign
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/28 14:17
 */
@FeignClient(name = "mycloud-auth", fallback = OAuth2ServerClientHystrix.class)
public interface OAuth2ServerClient {
    @RequestMapping(value = "/oauth/remove_token",method = RequestMethod.POST)
    Result removeToken(@RequestParam("token") String token);
}
