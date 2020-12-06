package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "center-city-area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class Center_city {
    private String henan;
    private String hubei;

    public String getHenan() {
        return henan;
    }

    public void setHenan(String henan) {
        this.henan = henan;
    }

    public String getHubei() {
        return hubei;
    }

    public void setHubei(String hubei) {
        this.hubei = hubei;
    }
}
