package com.cloud.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className BaseTest
 * @package base
 * @describe
 * @author hua.yang
 * @date 2020/10/27 11:46:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Test
    public void load(){
        LOGGER.info("Hello world!");
    }
}
