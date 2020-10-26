package com.rj.springcloud.dao;

import com.rj.springcloud.bean.TestInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 12:05
 */
@Mapper
public interface TestMapper {
    int insert(TestInfo testInfo);

    List<TestInfo> findByCondition(TestInfo testInfo);
}
