package com.website.company.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author: Peng Yangyan
 * @CreateDate: Created in 2018/11/22 9:40
 * @Description: 代码生成器
 */
public class Generator {
    public static void main(String[] args) {
        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("ld") //作者
                .setOutputDir("J:\\project\\test\\src\\main\\java") //生成路径
                .setFileOverride(false)  //文件覆盖
                .setServiceName("%sService")  //设置生成的Service接口名首字母知否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        return super.processTypeConvert(fieldType);
                    }
                })
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/datasystem?&serverTimezone=GMT%2B8&characterEncoding=utf-8")
                .setUsername("root")
                .setPassword("welcome123");

        //3.筞略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  //指定表是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)
//                .setTablePrefix(new String[]{"t_"})
                .setInclude(new String[]{"alarm","image","log","major","major_data","menu","role","sensor","sensor_bind","user"});

        //4.包策略配置
        PackageConfig pkconfig = new PackageConfig();
        pkconfig.setParent("cn.tycoding.demo")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("pojo");

        //5.整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkconfig);
        ag.execute();
    }
}
