package com.cloud.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.base.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息表 Mapper 接口
 *
 * @author mike.yang
 * @since 2020-10-27
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfo> selectPageByCondition(@Param("page") Page<?> page, @Param("obj") UserInfo obj);
}
