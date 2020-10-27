package com.rj.springcloud.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-27 14:03
 *
 * 使用@SpringBootTest编写测试类时，测试类的包路径要和SpringApplication扫描的包路径一致才可以
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);

    @Autowired
//    private TestMapper mapper;

    @Test
    public void print(){
        LOGGER.info("hello world!");
//        List list = mapper.selectList(null);
//        System.out.println(list);
    }
}
