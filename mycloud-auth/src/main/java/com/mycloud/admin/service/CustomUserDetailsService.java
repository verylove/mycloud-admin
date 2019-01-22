package com.mycloud.admin.service;

import com.mycloud.admin.domain.CustUserDetails;
import com.mycloud.admin.feign.UserClient;
import com.mycloud.common.model.AuthAccount;
import com.mycloud.common.result.Result;
import com.mycloud.common.result.ResultEnum;
import com.mycloud.common.utils.ObjectConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server
 * @Description: 自定义用户信息
 * @date 2018/4/12 15:35
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String name) {
        Result<AuthAccount> result = userClient.queryByName(name);
        if (ResultEnum.SUCCESS.getCode().equals(result.getCode())) {
            AuthAccount account = result.getData();
            CustUserDetails userDetails = ObjectConvertUtil.convert(account, CustUserDetails.class);
            log.debug("{}",userDetails);
            return userDetails;
        } else {
            throw new UsernameNotFoundException(name);
        }
    }
}
