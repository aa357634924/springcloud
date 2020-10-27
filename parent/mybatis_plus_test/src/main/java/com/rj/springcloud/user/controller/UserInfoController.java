package com.rj.springcloud.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rj.springcloud.user.service.UserInfoService;
import com.rj.springcloud.user.entity.UserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表 前端控制器
 *
 * @author rj
 * @since 2020-10-27
 */
@Api("UserInfoController 前端控制器接口文档")
@RestController
@RequestMapping("/UserInfoControlleruserInfo")
public class UserInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService service;

    @ApiOperation(value="插入或修改", notes="插入或修改", produces="application/json")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveOrUpdate(UserInfo obj){
        service.saveOrUpdate(obj);
        LOGGER.info("saveOrUpdate success...");
        return "saveOrUpdate success...";
    }

    @ApiOperation(value="根据条件进行分页查询", notes="根据条件进行分页查询", produces="application/json")
    @RequestMapping(value = "/findPageByCondition",method = RequestMethod.POST)
    public IPage<UserInfo> findPageByCondition(UserInfo obj){
        Page<UserInfo> page = new Page<UserInfo>();
        IPage<UserInfo> iPage = service.selectPageByCondition(page, obj);
        LOGGER.info("findPageByCondition success...");
        return iPage;
    }
}

