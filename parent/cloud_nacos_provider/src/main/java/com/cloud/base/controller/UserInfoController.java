package com.cloud.base.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.base.entity.UserInfo;
import com.cloud.base.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表 前端控制器
 *
 * @author mike.yang
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/UserInfoController")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    @RequestMapping("/findPageByCondition")
    public IPage<UserInfo> findPageByCondition(UserInfo testInfo){
        Page<UserInfo> page = new Page<UserInfo>();
        IPage<UserInfo> iPage = service.selectPageByCondition(page, testInfo);
        return iPage;
    }
}

