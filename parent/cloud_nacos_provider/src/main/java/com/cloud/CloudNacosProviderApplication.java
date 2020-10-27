package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author hua.yang
 * @className CloudNacosProvider
 * @package
 * @describe
 * @date 2020/10/27 11:27:00
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cloud.base.mapper")
public class CloudNacosProviderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProviderApplication.class, args);
    }
}
