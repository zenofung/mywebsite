package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "east-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class East_city {
    private String anhui;
    private String jiangsu;
    private String zhejiang;

    public String getAnhui() {
        return anhui;
    }

    public void setAnhui(String anhui) {
        this.anhui = anhui;
    }

    public String getJiangsu() {
        return jiangsu;
    }

    public void setJiangsu(String jiangsu) {
        this.jiangsu = jiangsu;
    }

    public String getZhejiang() {
        return zhejiang;
    }

    public void setZhejiang(String zhejiang) {
        this.zhejiang = zhejiang;
    }
}
