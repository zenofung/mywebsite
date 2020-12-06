package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "southwest-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class Southwest_city {
    private String guizhou;
    private String sichuan;
    private String xizang;
    private String yunnan;

    public String getGuizhou() {
        return guizhou;
    }

    public void setGuizhou(String guizhou) {
        this.guizhou = guizhou;
    }

    public String getSichuan() {
        return sichuan;
    }

    public void setSichuan(String sichuan) {
        this.sichuan = sichuan;
    }

    public String getXizang() {
        return xizang;
    }

    public void setXizang(String xizang) {
        this.xizang = xizang;
    }

    public String getYunnan() {
        return yunnan;
    }

    public void setYunnan(String yunnan) {
        this.yunnan = yunnan;
    }

}
