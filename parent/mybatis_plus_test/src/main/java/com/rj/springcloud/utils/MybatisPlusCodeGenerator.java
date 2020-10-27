package com.rj.springcloud.utils;


import cn.hutool.setting.dialect.Props;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *  mybatis-plus-generator 自动生成代码
 * @author rj
 * @version 1.0
 * @date 2020-10-26 19:50
 */
public class MybatisPlusCodeGenerator {
    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    // 数据库相关配置
    private static DataSourceConfig getDataSourceConfig(String url,String driverName,String username,String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        // schemaname [public]
        dataSourceConfig.setSchemaName("public");
        // 设置数据库字段类型转换类
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        // 驱动连接的URL
        dataSourceConfig.setUrl(url);
        // 驱动名称
        dataSourceConfig.setDriverName(driverName);
        // 数据库连接用户名
        dataSourceConfig.setUsername(username);
        // 密码
        dataSourceConfig.setPassword(password);
        return dataSourceConfig;
    }

    // 全局配置
    private static GlobalConfig getGlobalConfig(String projectPath,String author) {
        GlobalConfig globalConfig = new GlobalConfig();
        // 生成文件的输出目录 [默认为D://]
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        //实体属性 Swagger2 注解
        globalConfig.setSwagger2(true);
        // 是否覆盖已有文件 [false]
        globalConfig.setFileOverride(true);
        // 是否打开输出目录 [true]
        globalConfig.setOpen(false);
        // 是否在xml中添加二级缓存配置 [true]
        globalConfig.setEnableCache(false);
        // 设置作者(在生成的注解中显示) [默认为空]
        globalConfig.setAuthor(author);
        // 开启kotlin模式 [false]
        globalConfig.setKotlin(false);
        // 开启ActiveRecord模式 [false]
        globalConfig.setActiveRecord(false);
        // 开启BaseResultMap [false]
        globalConfig.setBaseResultMap(true);
        // 开启baseColumnList [false]
        globalConfig.setBaseColumnList(true);
        // mapper命名格式
        globalConfig.setMapperName("%sMapper");
        // xml命名格式
        globalConfig.setXmlName("%sMapper");
        // service命名格式
        globalConfig.setServiceName("%sService");
        // serviceImpl命名格式
        globalConfig.setServiceImplName("%sServiceImpl");
        // controller命名格式
        globalConfig.setControllerName("%sController");
        // 主键ID类型
        globalConfig.setIdType(IdType.ID_WORKER_STR);
        // 时间类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        return globalConfig;
    }

    // 跟包相关的配置项
    private static PackageConfig getPackageConfig(String parentPackagePath) {
        PackageConfig packageConfig = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        packageConfig.setParent(parentPackagePath);
        // 父包模块名
        packageConfig.setModuleName(scanner("模块名"));
        /***   下边的可以不用配置   ***/
        // Entity包名
        packageConfig.setEntity("entity");
        // Service包名
        packageConfig.setService("service");
        // Service Impl包名
        packageConfig.setServiceImpl("service.impl");
        // mapper包名
        packageConfig.setMapper("mapper");
        // mapper xml包名
        packageConfig.setXml("mapper");
        // controller包名
        packageConfig.setController("controller");
        return packageConfig;
    }

    // 策略配置项
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        // 是否大写命名
        strategyConfig.setCapitalMode(false);
        // 数据库表映射到实体的命名策略 [NamingStrategy.nochange]
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略,未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        String tablePrefix = scanner("表前缀(如：t_user,请输入: t_；无前缀则不需要输入)");
        // 表前缀
        strategyConfig.setTablePrefix(tablePrefix);
        // 字段前缀
        strategyConfig.setFieldPrefix(new String[] {});
        // 自定义继承的Entity类全称，带包名
        // strategyConfig.setSuperEntityClass();
        // 自定义基础的Entity类，公共字段
        // strategyConfig.setSuperEntityColumns();
        // 自定义继承的Mapper类全称，带包名
        strategyConfig.setSuperMapperClass(ConstVal.SUPER_MAPPER_CLASS);
        // 自定义继承的Service类全称，带包名
        strategyConfig.setSuperServiceClass(ConstVal.SUPER_SERVICE_CLASS);
        // 自定义继承的ServiceImpl类全称，带包名
        strategyConfig.setSuperServiceImplClass(ConstVal.SUPER_SERVICE_IMPL_CLASS);
        // 自定义继承的Controller类全称，带包名
        // strategyConfig.setSuperControllerClass();
        // 需要包含的表名（与exclude二选一配置） [null]
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 需要排除的表名 [null]
        // strategyConfig.setExclude();
        // 是否生成字段常量（默认 false）
        strategyConfig.setEntityColumnConstant(false);
        // 是否为构建者模式 (默认false) 构建者模式:set方法返回this
        strategyConfig.setEntityBuilderModel(false);
        // 是否为lombok模型(默认false0
        strategyConfig.setEntityLombokModel(true);
        // Boolean类型字段是否移除is前缀（默认 false）
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(false);
        // 设置Controller为RestController [false]
        strategyConfig.setRestControllerStyle(true);
        // mapping中驼峰转连字符 [false]
        strategyConfig.setControllerMappingHyphenStyle(true);
        // 是否生成实体时，生成字段注解
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //// 表填充字段 [null] 自动填充的配置
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);//设置时的生成策略
        TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);//设置更新时间的生成策略
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(create_time);
        list.add(update_time);
        strategyConfig.setTableFillList(list);
        // 乐观锁属性名称
        // strategyConfig.setVersionFieldName();
        // 逻辑删除属性名称
        // strategyConfig.setLogicDeleteFieldName();
        return strategyConfig;
    }

    // 设置生成模板,如果不设置,则使用mybatisplus默认的模板,
    // 所有的模板在mybatis-plus-generator-3.2.0.jar包下的templates文件夹下面，可以复制到resources目录下使用
    private static TemplateConfig getTemplateConfig(String templatePath) {
        TemplateConfig templateConfig = new TemplateConfig();
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity(templatePath+"/entity.java");
        templateConfig.setService(templatePath+"/service.java");
        templateConfig.setServiceImpl(templatePath+"/serviceImpl.java");
        templateConfig.setController(templatePath+"/controller.java");
        templateConfig.setMapper(templatePath+"/mapper.java");
//        templateConfig.setXml(templatePath+"/mapper.xml");
        templateConfig.setXml(null);
        return templateConfig;
    }

    //自定义配置
    private static InjectionConfig getInjectionConfig(PackageConfig pc,String projectPath,String templatePath) {
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {

            }
        };
        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        templatePath = templatePath + "/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    public static void main(String[] args) {
        //读取配置信息
        Props prop = Props.getProp("mybatisPlusGenerator.yml", "utf-8");
        String driverName = prop.getProperty("driverName").trim();
        String url = prop.getProperty("url").trim();
        String username = prop.getProperty("username").trim();
        String password = prop.getProperty("password").trim();
        String templatePath = prop.getProperty("templatePath").trim();
        String author = prop.getProperty("author").trim();
        String projectPath = prop.getProperty("projectPath").trim();
        String parentPackagePath = prop.getProperty("parentPackagePath").trim();

        //执行代码自动生成
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置  user.dir 项目根路径
        if(StringUtils.isEmpty(projectPath)){
            projectPath = System.getProperty("user.dir");
        }
        GlobalConfig gc = getGlobalConfig(projectPath,author);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig(url,driverName,username,password);
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pc = getPackageConfig(parentPackagePath);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = getStrategyConfig();
        mpg.setStrategy(strategy);

        // 配置模板
        TemplateConfig templateConfig = getTemplateConfig(templatePath);
        mpg.setTemplate(templateConfig);
        // 配置模板引擎
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setTemplateEngine(new VelocityTemplateEngine());

        // 自定义配置
        InjectionConfig cfg = getInjectionConfig(pc,projectPath,templatePath);
        mpg.setCfg(cfg);
        mpg.execute();
    }
}
