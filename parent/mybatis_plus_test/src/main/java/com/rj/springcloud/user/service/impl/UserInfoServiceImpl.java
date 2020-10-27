package com.rj.springcloud.user.service.impl;

import com.rj.springcloud.user.entity.UserInfo;
import com.rj.springcloud.user.mapper.UserInfoMapper;
import com.rj.springcloud.user.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户信息表 服务实现类
 *
 * @author rj
 * @since 2020-10-27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper mapper;

    @Override
    public IPage<UserInfo> selectPageByCondition(Page<?> page, UserInfo obj){
        return mapper.selectPageByCondition(page,obj);
    }
}
