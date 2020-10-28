# springcloud
* springclod-版本信息

     spring-cloud-dependencies H.SR8
     spring-boot-dependencies 2.3.4.RELEASE
     spring-cloud-alibaba-dependencies 2.2.3.RELEASE
     <!--统一管理jar包和版本-->
         <properties>
             <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
             <maven.compiler.source>1.8</maven.compiler.source>
             <maven.compiler.target>1.8</maven.compiler.target>
             <junit.version>4.12</junit.version>
             <log4j.version>1.2.17</log4j.version>
             <lombok.version>1.16.18</lombok.version>
             <mysql.version>8.0.13</mysql.version>
             <druid.verison>1.1.20</druid.verison>
             <swagger2.verison>2.9.2</swagger2.verison>
             <velocity.verison>2.1</velocity.verison>
             <hutool.verison>5.1.0</hutool.verison>
             <fastjson.verison>1.2.47</fastjson.verison>
             <mybatis.spring.boot.verison>2.1.3</mybatis.spring.boot.verison>
             <mybatisplus.spring.boot.verison>3.4.0</mybatisplus.spring.boot.verison>
         </properties>
     
* 项目介绍

* 项目1：mybatis_plus_test

    * 1）自动生成controller、service、serviceImpl、entity、mapper、mapper.xml
注：自动生成entity时，druid版本需要1.1.20以上，否则时间类型的字段会报错

    * 2）搭载swagger2，自动生成接口文档，访问路径为: 访问swagger路径：http://localhost:8080/mybatis/swagger-ui.html

    * 3）使用@SpringBootTest编写测试类时，测试类的包路径要和SpringApplication扫描的包路径一致才可以
    
    * 4） mybatis-plus-generator使用方法：
         * 1.将mybatis-plus的模板文件复制到resources目录下
         * 2.在resources跟目录下创建mybatisPlusGenerator.yml
         * 3.在mybatisPlusGenerator.yml中填写属性配置
         * 4.执行main方法，输入模块名称、表头格式、表名即可自动创建代码（多个表名之间用英文逗号分隔）
    
    * 5）乐观锁配置：
        * 1.数据库表中增加一个int型的 version 字段
        * 2.实体类中version字段增加 @Version 和 @TableField(value = "version", fill = FieldFill.INSERT)
        * 3.在任意一个@Configuration配置类中引入乐观锁插件（此系统所有关于mybatis的配置统一在MybatisPlusConfig.java中进行设置）
            @Bean
            public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
                return new OptimisticLockerInnerInterceptor();
            }
        * 4.MetaObjectHandler.insertFill中对version设置一个初始值
            //乐观锁版本号  新增的时候需要设置一个默认值，修改的时候mybatis-plus会自动添加
            setFieldValByName("version", 1, metaObject);
            
    * 6）分页插件
        * 1.在任意一个@Configuration配置类中引入乐观锁插件（此系统所有关于mybatis的配置统一在MybatisPlusConfig.java中进行设置）
            @Bean
            public MybatisPlusInterceptor mybatisPlusInterceptor() {
                MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
                interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
                return interceptor;
            } 
        * 2.使用Page和QueryWrapper进行分页查询
            QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("username",obj.getUsername());
            Page<Test> page = service.page(new Page<Test>(), queryWrapper); 
            
    * 7）逻辑删除
        * 1.application.yml中引入逻辑删除的配置
            logic-delete-value: 1 # 逻辑已删除值(默认为 1)
            logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
        * 2.数据库表中增加一个boolean字段，名字自己定义，此处设置为"deleted"
        * 3.entity实体类中增加 @TableLogic 逻辑删除标识
            @TableField(value = "deleted", fill = FieldFill.INSERT)
            @TableLogic
        * 4.MetaObjectHandler.insertFill中对 "deleted" 设置一个初始值 0
            setFieldValByName("deleted", 0, metaObject);
    