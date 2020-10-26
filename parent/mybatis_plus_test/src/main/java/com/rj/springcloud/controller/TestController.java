package com.rj.springcloud.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rj.springcloud.bean.TestInfo;
import com.rj.springcloud.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 11:23
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/index")
    public String test(){
        return "test success...";
    }

    @RequestMapping("/insert")
    public String insert(TestInfo testInfo){
        testInfo = new TestInfo();
        testInfo.setUsername("张三");
        testInfo.setOperTime(new Date());
        testService.insert(testInfo);
        return "insert success...";
    }

    @RequestMapping("/findByCondition")
    public List<TestInfo> findByCondition(TestInfo testInfo){
        testInfo = new TestInfo();
        testInfo.setId(1);
        List<TestInfo> list = testService.findByCondition(testInfo);
        logger.info("查询成功。。。");
        return list;
    }

    @RequestMapping("/findPage")
    public List<TestInfo> findPage(TestInfo testInfo){
        testInfo = new TestInfo();
        testInfo.setId(1);
        Page<TestInfo> page = new Page<TestInfo>(1,10);
        IPage<TestInfo> testInfoIPage = testService.selectUserPage(page, testInfo);
        List<TestInfo> list = testInfoIPage.getRecords();
        logger.info("查询成功。。。");
        return list;
    }
}
