# springcloud
一、springclod-版本信息

     spring-cloud-dependencies H.SR8
     spring-boot-dependencies 2.2.3.RELEASE
     spring-cloud-alibaba-dependencies 2.2.3.RELEASE
     <properties>
             <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
             <maven.compiler.source>1.8</maven.compiler.source>
             <maven.compiler.target>1.8</maven.compiler.target>
             <junit.version>4.12</junit.version>
             <log4j.version>1.2.17</log4j.version>
             <lombok.version>1.16.18</lombok.version>
             <mysql.version>8.0.13</mysql.version>
             <druid.verison>1.1.20</druid.verison>
             <mybatis.spring.boot.verison>1.3.0</mybatis.spring.boot.verison>
         </properties>
     
二、项目介绍

项目1：mybatis_plus_test

1）自动生成controller、service、serviceImpl、entity、mapper、mapper.xml
注：自动生成entity时，druid版本需要1.1.20以上，否则时间类型的字段会报错

2）搭载swagger2，自动生成接口文档，访问路径为: 访问swagger路径：http://localhost:8080/mybatis/swagger-ui.html

