package com.rj.springcloud.service.impl;

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
}
