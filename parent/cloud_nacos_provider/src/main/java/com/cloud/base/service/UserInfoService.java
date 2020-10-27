package com.cloud.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.base.dto.UserInfoDTO;
import com.cloud.base.entity.UserInfo;

/**
 * 用户信息表 服务类
 *
 * @author mike.yang
 * @since 2020-10-27
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     *
     * @methodName
     * @param
     * @return
     * @author hua.yang
     * @date 2020/10/27 12:28:00
     */
    public boolean create(UserInfoDTO userInfoDTO) throws Exception;

    public IPage<UserInfo> selectPageByCondition(Page<?> page, UserInfo obj);
}
