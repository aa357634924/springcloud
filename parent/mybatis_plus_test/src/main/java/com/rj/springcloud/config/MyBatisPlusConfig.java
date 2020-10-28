package com.rj.springcloud.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

/**
 * TODO
 * 1.配置分页对象
 * 2.添加、修改时，自动填充创建时间和修改时间
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-26 13:28
 */
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig implements MetaObjectHandler {

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 乐观锁插件
     * */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 添加操作
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object gmtCreate = null;
        Object gmtModified = null;
        if (metaObject.hasGetter("gmtCreate")) {
            gmtCreate = getFieldValByName("gmtCreate", metaObject);
        }
        if (metaObject.hasGetter("gmtModified")) {
            gmtModified = getFieldValByName("gmtModified", metaObject);
        }
        Date now = new Date();
        if (gmtCreate == null && metaObject.hasSetter("gmtCreate")) {
            setFieldValByName("gmtCreate", now, metaObject);
        }
        if (gmtModified == null && metaObject.hasSetter("gmtModified")) {
            setFieldValByName("gmtModified", now, metaObject);
        }
        //乐观锁版本号  新增的时候需要设置一个默认值，修改的时候mybatis-plus会自动添加
        if (metaObject.hasSetter("version")) {
            setFieldValByName("version", 1, metaObject);
        }
        //逻辑删除，新增数据时，增加默认值0-未删除
        if (metaObject.hasSetter("isDeleted")) {
            setFieldValByName("isDeleted", 0, metaObject);
        }
    }

    /**
     * 修改操作
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object gmtModified = null;
        Date now = new Date();
        if (metaObject.hasGetter("gmtModified")) {
            gmtModified = getFieldValByName("gmtModified", metaObject);
        }
        if (gmtModified == null && metaObject.hasSetter("gmtModified")) {
            setFieldValByName("gmtModified", now, metaObject);
        }
    }
}