package com.rj.springcloud.user.service;

import com.rj.springcloud.user.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户信息表 服务类
 *
 * @author rj
 * @since 2020-10-27
 */
public interface UserInfoService extends IService<UserInfo> {
    public IPage<UserInfo> selectPageByCondition(Page<?> page, UserInfo obj);
}
