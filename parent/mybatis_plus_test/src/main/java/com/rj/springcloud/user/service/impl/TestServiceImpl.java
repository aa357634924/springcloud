package com.rj.springcloud.user.service.impl;

import com.rj.springcloud.user.entity.Test;
import com.rj.springcloud.user.mapper.TestMapper;
import com.rj.springcloud.user.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 测试表 服务实现类
 *
 * @author rj
 * @since 2020-10-27
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Resource
    private TestMapper mapper;

    @Override
    public IPage<Test> selectPageByCondition(Page<?> page, Test obj){
        return mapper.selectPageByCondition(page,obj);
    }
}
