package com.cloud.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.base.dto.UserInfoDTO;
import com.cloud.base.entity.UserInfo;
import com.cloud.base.mapper.UserInfoMapper;
import com.cloud.base.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.BeanCopyUtils;

import javax.annotation.Resource;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

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
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRED)
    public boolean create(UserInfoDTO userInfoDTO) throws Exception {
        if (userInfoDTO != null) {
            UserInfo userInfo = BeanCopyUtils.getBeanCopy(userInfoDTO, UserInfo.class);
            boolean result = save(userInfo);
            if (result) {
                return result;
            }
        }
        throw new Exception("");
    }

    @Override
    public IPage<UserInfo> selectPageByCondition(Page<?> page, UserInfo obj) {
        return mapper.selectPageByCondition(page, obj);
    }
}
