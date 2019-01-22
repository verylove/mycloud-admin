package com.mycloud.admin.config;

import com.mycloud.admin.handler.CustomAccessDeniedHandler;
import com.mycloud.admin.handler.CustomAuthEntryPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author huangqi
 * @Package com.mycloud.admin.config
 * @Description: ResourceServerConfig
 * @date 2018/6/27 9:39
 */
@Slf4j
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Resource
    private CustomAuthEntryPoint customAuthEntryPoint;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint)
                .and().authorizeRequests()
                .antMatchers("/oauth/remove_token").permitAll()
                .anyRequest().authenticated();
        ;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.authenticationEntryPoint(customAuthEntryPoint).accessDeniedHandler(customAccessDeniedHandler);
    }
}