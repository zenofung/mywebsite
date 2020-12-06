package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "northeast-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class Northeast_city {
    private String heilongjiang;
    private String jilin;
    private String liaoning;

    public String getHeilongjiang() {
        return heilongjiang;
    }

    public void setHeilongjiang(String heilongjiang) {
        this.heilongjiang = heilongjiang;
    }

    public String getJilin() {
        return jilin;
    }

    public void setJilin(String jilin) {
        this.jilin = jilin;
    }

    public String getLiaoning() {
        return liaoning;
    }

    public void setLiaoning(String liaoning) {
        this.liaoning = liaoning;
    }
}
