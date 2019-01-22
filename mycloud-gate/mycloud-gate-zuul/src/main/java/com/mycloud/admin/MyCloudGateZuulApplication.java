package com.mycloud.admin;

import com.mycloud.admin.filter.PreRequestZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
@EnableFeignClients
public class MyCloudGateZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudGateZuulApplication.class, args);
    }

    @Bean
    public PreRequestZuulFilter preRequestZuulFilter(){
        return new PreRequestZuulFilter();
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
