package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className CloudNacosProvider
 * @package
 * @describe
 * @author hua.yang
 * @date 2020/10/27 11:27:00
 */
@SpringBootApplication
@MapperScan("com.cloud.*.mapper")
public class CloudNacosProvider {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProvider.class ,args);
    }
}
