package com.rj.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 20:05
 * 访问swagger路径：http://localhost:8080/mybatis/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.rj.springcloud";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot整合Swagger")//设置文档的标题
                        .description("系统框架：SpringBoot、mybatis-plus、log4j2、Swagger2、mysql5.7、jdk1.8、maven")// 设置文档的描述
                        .version(VERSION)// 设置文档的版本信息-> 1.0.0 Version information
                        .contact(new Contact("git地址：", "https://github.com/aa357634924/springcloud/tree/main/parent/mybatis_plus_test", "357634924@qq.com"))
                        .license("The Apache License")
                        .licenseUrl("https://github.com/aa357634924")
                        .build());
    }
}

