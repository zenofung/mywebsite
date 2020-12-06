package com.website.company.areaconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties(prefix = "area", ignoreUnknownFields = false)
@PropertySource("classpath:area.properties")
@Component
public class AreaName {
    private String main_area;
    private String south_area;
    private String north_area;
    private String east_area;
    private String center_area;
    private String northeast_area;
    private String southwest_area;
    private String northweat_area;

    public String getSouth_area() {
        return south_area;
    }

    public void setSouth_area(String south_area) {
        this.south_area = south_area;
    }

    public String getNorth_area() {
        return north_area;
    }

    public void setNorth_area(String north_area) {
        this.north_area = north_area;
    }

    public String getEast_area() {
        return east_area;
    }

    public void setEast_area(String east_area) {
        this.east_area = east_area;
    }

    public String getCenter_area() {
        return center_area;
    }

    public void setCenter_area(String center_area) {
        this.center_area = center_area;
    }

    public String getNortheast_area() {
        return northeast_area;
    }

    public void setNortheast_area(String northeast_area) {
        this.northeast_area = northeast_area;
    }

    public String getSouthwest_area() {
        return southwest_area;
    }

    public void setSouthwest_area(String southwest_area) {
        this.southwest_area = southwest_area;
    }

    public String getNorthweat_area() {
        return northweat_area;
    }

    public void setNorthweat_area(String northweat_area) {
        this.northweat_area = northweat_area;
    }

    public String getMain_area() {
        return main_area;
    }

    public void setMain_area(String main_area) {
        this.main_area = main_area;
    }

    public String toString() {
        return south_area + north_area + east_area + center_area + northeast_area + southwest_area + northweat_area;
    }
}
