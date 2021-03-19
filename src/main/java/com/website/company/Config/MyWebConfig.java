package com.website.company.Config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 
 *          ________
 *          ___  __/______________
 *          __  /_ ___  __ \  ___/
 *          _  __/ __  /_/ / /__
 *          /_/    _  .___/\___/
 *                 /_/
 * @author: www.fpcs.top
 *
 * @create: 2021-03-02 15:36
 */
@Configuration
//@EnableWebMvc
public class MyWebConfig implements WebMvcConfigurer {


//    // 第二种 当前跨域请求最大有效时长。这里默认30天
//    private long maxAge = 30 * 24 * 60 * 60;
//
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址
//        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
//        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
//        corsConfiguration.setMaxAge(maxAge);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
//        return new CorsFilter(source);
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://test.qszhuang.com:8080",
//                        "http://mall.qszhuang.com:",
//                        "http://192.168.100.172:8080",
//                        "http://192.168.100.144:8080",
//                        "http://192.168.100.173",
//                        "http://127.0.0.1:28637",
//                        "http://192.168.100.144:28637",
//                        "http://192.168.100.144:8081")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }


    // 一种跨域

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //设置允许跨域的路径
                .allowedOrigins("*")
                //设置允许跨域请求的域名
                .allowedMethods("*")
                //是否允许证书 不再默认开启
                .allowedHeaders("*")
                .allowCredentials(true);
        //设置允许的方法
        // .allowedMethods("GET", "POST")
        // //跨域允许时间
        // .maxAge(3600);
    }
}