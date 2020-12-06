package com.website.company;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@MapperScan({"com.website.company.mapper*"})
@ServletComponentScan(basePackages = "com.website.company.ServletClass")
@SpringBootApplication
public class CompanyApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        // WebAppResourceLoader 配置root路径是关键
        //  WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader();
        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
        // patternResolver.getResource("classpath:/beetl.properties").getFile().getPath()
        beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:/beetl.properties"));
        //读取配置文件信息
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix("/WEB-INF/views/");
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

//    @Bean
//    public GroupTemplate getGroupTemplate(BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
//        GroupTemplate gt = beetlGroupUtilConfiguration.getGroupTemplate();
//        Map<String,Object> shared = new HashMap<>();
//        shared.put("keywords","智能马桶, 智能马桶盖,智能座便器,智能马桶哪个牌子好,智能马桶盖十大名牌,智能座便器价格");
//        shared.put("description","重庆恭逸科技有限公司（023-62386151）致力于智能马桶、智能马桶盖、智能座便器、研发生产、加盟.如果您有智能马桶十大名牌, 智能马桶盖哪个牌子好, 智能座便器价格相关问题，欢迎咨询！");
//        shared.put("title","智能马桶哪个牌子好_智能马桶盖十大名牌_智能座便器价格_重庆恭逸科技有限公司");
//        gt.setSharedVars(shared);
//        return gt;
//    }
}
