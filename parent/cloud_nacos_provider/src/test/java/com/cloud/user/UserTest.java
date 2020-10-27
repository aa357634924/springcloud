package com.cloud.user;

import com.cloud.base.BaseTest;
import com.cloud.base.entity.UserInfo;
import com.cloud.base.mapper.UserInfoMapper;
import com.cloud.base.service.UserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;


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

    @Resource
    private UserInfoMapper userInfoMapper;

    @Test
    public void test(){
        LOGGER.info("hello user test! ");
    }

    @Test
    public void addUserTest() throws Exception {

        UserInfo userInfoDTO = new UserInfo();
        userInfoDTO.setUsername("yanghuazzg");
        userInfoDTO.setPassword("123456789");
        userInfoDTO.setPhone("18515657116");
        userInfoDTO.setRealName("杨桦");
        userInfoDTO.setSex("男");
        userInfoDTO.setPhoto("wetfghklj;jopdjfpwe");
        userInfoDTO.setEmail("xxxxx.@qq.com");
        userInfoDTO.setCardId("110********0313");
        userInfoDTO.setAddress("BJ");
        userInfoDTO.setOprator("123456789");
        userInfoDTO.setStatus("01");
        userInfoDTO.setOperatorName("操作员");
        userInfoDTO.setCreateTime(new Date());
        userInfoDTO.setUpdateTime(new Date());
        userInfoMapper.insert(userInfoDTO);
    }


}
