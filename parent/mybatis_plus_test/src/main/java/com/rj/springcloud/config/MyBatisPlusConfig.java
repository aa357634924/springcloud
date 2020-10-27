package com.rj.springcloud.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
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
     * 此处不配置，分页不生效
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 设置方言
        paginationInterceptor.setDialectType("mysql");
        // 开启 count 的 join 优化,只针对 left join !!!
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     * */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 添加操作
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = null;
        Object updateTime = null;
        if (metaObject.hasGetter("createTime")) {
            createTime = getFieldValByName("createTime", metaObject);
        }
        if (metaObject.hasGetter("updateTime")) {
            updateTime = getFieldValByName("updateTime", metaObject);
        }
        Date now = new Date();
        if (createTime == null && metaObject.hasSetter("createTime")) {
            setFieldValByName("createTime", now, metaObject);
        }
        if (updateTime == null && metaObject.hasSetter("updateTime")) {
            setFieldValByName("updateTime", now, metaObject);
        }
        //乐观锁版本号  新增的时候需要设置一个默认值，修改的时候mybatis-plus会自动添加
        setFieldValByName("version", 1, metaObject);
    }

    /**
     * 修改操作
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = null;
        Date now = new Date();
        if (metaObject.hasGetter("updateTime")) {
            updateTime = getFieldValByName("updateTime", metaObject);
        }
        if (updateTime == null && metaObject.hasSetter("updateTime")) {
            setFieldValByName("updateTime", now, metaObject);
        }
    }
}
