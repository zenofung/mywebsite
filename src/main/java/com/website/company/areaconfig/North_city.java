package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "north-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class North_city {
    private String hebei;
    private String neimenggu;

    public String getHebei() {
        return hebei;
    }

    public void setHebei(String hebei) {
        this.hebei = hebei;
    }

    public String getNeimenggu() {
        return neimenggu;
    }

    public void setNeimenggu(String neimenggu) {
        this.neimenggu = neimenggu;
    }

    public String getShandong() {
        return shandong;
    }

    public void setShandong(String shandong) {
        this.shandong = shandong;
    }

    public String getShanxi() {
        return shanxi;
    }

    public void setShanxi(String shanxi) {
        this.shanxi = shanxi;
    }

    private String shandong;
    private String shanxi;
}
