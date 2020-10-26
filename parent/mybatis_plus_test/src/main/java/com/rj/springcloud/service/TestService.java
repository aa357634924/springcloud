package com.rj.springcloud.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rj.springcloud.bean.TestInfo;

import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 12:17
 */
public interface TestService {
    public int insert(TestInfo testInfo);

    public List<TestInfo> findByCondition(TestInfo testInfo);

    public IPage<TestInfo> selectUserPage(Page<TestInfo> page, TestInfo testInfo);
}
