package com.mycloud.admin.config;

import com.mycloud.admin.config.security.MyAccessDecisionManager;
import com.mycloud.admin.config.security.UrlFilterSecurityMetadataSource;
import com.mycloud.admin.handler.CustomAccessDeniedHandler;
import com.mycloud.admin.handler.CustomAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * @author huangqi
 * @Package com.mycloud.admin.config
 * @Description: ResourceServerConfig
 * @date 2018/6/27 9:39
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Autowired
    private AuthorizationServerProperties authorizationServerProperties;

    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private UrlFilterSecurityMetadataSource urlFilterSecurityMetadataSource;

    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;


    @Bean
    public AuthorizationServerProperties authorizationServerProperties() {
        return new AuthorizationServerProperties();
    }
    //跨域拦截器
    @Bean
    public CorsFilter corsFilter() throws Exception {
        return new CorsFilter();
    }

    @Bean
    @Qualifier("authorizationHeaderRequestMatcher")
    public RequestMatcher authorizationHeaderRequestMatcher() {
        return new RequestHeaderRequestMatcher("Authorization");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .addFilterBefore(corsFilter(), SecurityContextPersistenceFilter.class)
                .authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(urlFilterSecurityMetadataSource);
                o.setAccessDecisionManager(myAccessDecisionManager);
                return o;

            }
        })
                .and()
                .csrf()
                .disable()
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint)
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .requestMatcher(new AntPathRequestMatcher("/api-user/**"))
//                .requestMatcher(authorizationHeaderRequestMatcher())
                .authorizeRequests()
//                .antMatchers("/auth/login","/auth/logout","/system/info").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices())
                .accessDeniedHandler(customAccessDeniedHandler)
                .authenticationEntryPoint(customAuthEntryPoint);


    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("mycloud-jwt.cert");
        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }


    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
        remoteTokenServices.setClientId(oAuth2ClientProperties.getClientId());
        remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
        return remoteTokenServices;
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }


}
