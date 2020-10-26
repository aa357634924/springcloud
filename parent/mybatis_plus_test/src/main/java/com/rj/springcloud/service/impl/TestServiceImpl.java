package com.rj.springcloud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rj.springcloud.bean.TestInfo;
import com.rj.springcloud.dao.TestMapper;
import com.rj.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 12:18
 */
@Service("testService")
public class TestServiceImpl implements Serializable, TestService {
    @Resource
    private TestMapper testMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int insert(TestInfo testInfo) {
        return testMapper.insert(testInfo);
    }

    @Override
    public List<TestInfo> findByCondition(TestInfo testInfo) {
        return testMapper.findByCondition(testInfo);
    }

    public IPage<TestInfo> selectUserPage(Page<TestInfo> page, TestInfo testInfo) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return testMapper.selectPageVo(page, testInfo);
    }
}
