//package com.rj.springcloud.utils;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import org.junit.Test;
//
///**
// * <p>
// * 自动生成代码
// * </p>
// */
//public class GeneratorServiceEntity {
//
//    @Test
//    public void generateCode() {
//        String packageName = "com";
//        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
//        generateByTables(serviceNameStartWithI, packageName, "chat_friends","chat_msg","collect","commcategory","comment","commimages","commodity","login","news","notices","reply","school","soldrecord","user","user_perm","user_role");
//    }
//
//    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
//        GlobalConfig config = new GlobalConfig();
//        String dbUrl = "jdbc:mysql://localhost:3306/shop";
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setDbType(DbType.MYSQL)
//                .setUrl(dbUrl)
//                .setUsername("root")
//                .setPassword("123456")
//                .setDriverName("com.mysql.jdbc.Driver");
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig
//                .setCapitalMode(true)
//                .setEntityLombokModel(true) // 【实体】是否为lombok模型（默认 false)
//                .setDbColumnUnderline(true)
//                .setNaming(NamingStrategy.underline_to_camel)
//                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
//        config.setActiveRecord(false)
//                .setAuthor("hlt")
//                .setOutputDir("F://MpGenerator")
//                .setFileOverride(true);
//        if (!serviceNameStartWithI) {
//            config.setServiceName("%sService");
//        }
//        new AutoGenerator().setGlobalConfig(config)
//                .setDataSource(dataSourceConfig)
//                .setStrategy(strategyConfig)
//                .setPackageInfo(
//                        new PackageConfig()
//                                .setParent(packageName)
//                                .setController("controller")
//                                .setEntity("entity")
//                ).execute();
//    }
//
//    private void generateByTables(String packageName, String... tableNames) {
//        generateByTables(true, packageName, tableNames);
//    }
//}
