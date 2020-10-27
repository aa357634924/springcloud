# springcloud
一、springclod-版本信息

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
             <mybatisplus.spring.boot.verison>3.2.0</mybatisplus.spring.boot.verison>
         </properties>
     
二、项目介绍

项目1：mybatis_plus_test

1）自动生成controller、service、serviceImpl、entity、mapper、mapper.xml
注：自动生成entity时，druid版本需要1.1.20以上，否则时间类型的字段会报错

2）搭载swagger2，自动生成接口文档，访问路径为: 访问swagger路径：http://localhost:8080/mybatis/swagger-ui.html

