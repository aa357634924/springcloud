package com.cloud.user;

import com.cloud.base.BaseTest;
import com.cloud.base.service.UserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
  * @className UserTest
  * @package com.cloud.user
  * @describe
  * @author hua.yang
  * @date 2020/10/27 12:21:00
  */
public class UserTest extends BaseTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test(){
        LOGGER.info("hello user test! ");
    }

    @Test
    public void addUserTest(){

    }


}
