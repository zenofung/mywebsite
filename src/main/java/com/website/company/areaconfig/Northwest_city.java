package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "northwest-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class Northwest_city {
    private String gansu;
    private String ningxia;
    private String qinghai;
    private String shanxi;
    private String xinjiang;

    public String getGansu() {
        return gansu;
    }

    public void setGansu(String ansu) {
        this.gansu = ansu;
    }

    public String getNingxia() {
        return ningxia;
    }

    public void setNingxia(String ningxia) {
        this.ningxia = ningxia;
    }

    public String getQinghai() {
        return qinghai;
    }

    public void setQinghai(String qinghai) {
        this.qinghai = qinghai;
    }

    public String getShanxi() {
        return shanxi;
    }

    public void setShanxi(String shanxi) {
        this.shanxi = shanxi;
    }

    public String getXinjiang() {
        return xinjiang;
    }

    public void setXinjiang(String xinjiang) {
        this.xinjiang = xinjiang;
    }
}
