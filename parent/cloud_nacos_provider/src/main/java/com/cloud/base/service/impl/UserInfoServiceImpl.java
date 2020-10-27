package com.cloud.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.base.dto.UserInfoDTO;
import com.cloud.base.entity.UserInfo;
import com.cloud.base.mapper.UserInfoMapper;
import com.cloud.base.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表 服务实现类
 *
 * @author mike.yang
 * @since 2020-10-27
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private UserInfoMapper mapper;

    @Override
    public int create(UserInfoDTO userInfoDTO) {
        return 0;
    }

    @Override
    public IPage<UserInfo> selectPageByCondition(Page<?> page, UserInfo obj){
        return mapper.selectPageByCondition(page,obj);
    }
}
