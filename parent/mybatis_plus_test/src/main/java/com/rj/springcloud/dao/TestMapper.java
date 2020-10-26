package com.rj.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface TestMapper extends BaseMapper<TestInfo> {
    int insert(TestInfo testInfo);

    List<TestInfo> findByCondition(TestInfo testInfo);
    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    IPage<TestInfo> selectPageVo(Page<?> page, TestInfo testInfo);
}
