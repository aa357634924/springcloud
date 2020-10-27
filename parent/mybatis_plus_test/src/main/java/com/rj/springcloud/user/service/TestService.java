package com.rj.springcloud.user.service;

import com.rj.springcloud.user.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 测试表 服务类
 *
 * @author rj
 * @since 2020-10-27
 */
public interface TestService extends IService<Test> {
    public IPage<Test> selectPageByCondition(Page<?> page, Test obj);
}
