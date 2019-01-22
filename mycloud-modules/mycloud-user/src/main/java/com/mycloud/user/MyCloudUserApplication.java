package com.mycloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.mycloud.user.mapper")
public class MyCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCloudUserApplication.class, args);
    }
}
