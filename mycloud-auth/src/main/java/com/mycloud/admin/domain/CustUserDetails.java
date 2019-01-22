package com.mycloud.admin.domain;

import com.mycloud.common.model.AuthRoles;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server.domain
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/4/13 11:28
 */
@Data
public class CustUserDetails implements UserDetails {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String avatar;
    private String introduction;

    private boolean enabled;

    /**
     * 账户没有超时
     */
    private boolean accountNonExpired;
    /**
     * 账户是否被锁定
     */
    private boolean accountNonLocked;
    /**
     * 凭证是否超时
     */
    private boolean credentialsNonExpired;

    private List<AuthRoles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (AuthRoles role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return authorities;
    }

}
