package com.rj.springcloud.user.mapper;

import com.rj.springcloud.user.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息表 Mapper 接口
 *
 * @author rj
 * @since 2020-10-27
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfo> selectPageByCondition(@Param("page") Page<?> page,@Param("obj") UserInfo obj);
}
