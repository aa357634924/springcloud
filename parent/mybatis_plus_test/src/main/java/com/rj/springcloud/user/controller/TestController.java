package com.rj.springcloud.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rj.springcloud.user.service.TestService;
import com.rj.springcloud.user.entity.Test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RestController;

/**
 * 测试表 前端控制器
 *
 * @author rj
 * @since 2020-10-27
 */
@Api("TestController 前端控制器接口文档")
@RestController
@RequestMapping("/TestControllertest")
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService service;

    @ApiOperation(value="插入或修改", notes="插入或修改", produces="application/json")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveOrUpdate(Test obj){
        service.saveOrUpdate(obj);
        LOGGER.info("saveOrUpdate success...");
        return "saveOrUpdate success...";
    }

    @ApiOperation(value="根据条件进行分页查询", notes="根据条件进行分页查询", produces="application/json")
    @RequestMapping(value = "/findPageByCondition",method = RequestMethod.POST)
    public IPage<Test> findPageByCondition(Test obj){
        Page<Test> page = new Page<Test>();
        IPage<Test> iPage = service.selectPageByCondition(page, obj);
        LOGGER.info("findPageByCondition success...");
        return iPage;
    }
}

