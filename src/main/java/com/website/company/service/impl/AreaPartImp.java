package com.website.company.service.impl;

import com.website.company.areaconfig.*;
import com.website.company.entity.User;
import com.website.company.service.AreaPart;
import com.website.company.utils.AreaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Service
public class AreaPartImp implements AreaPart {

    @Autowired
    AreaName areaName;
    @Autowired
    Center_city center_city;
    @Autowired
    East_city east_city;
    @Autowired
    Northwest_city northwest_city;
    @Autowired
    North_city north_city;
    @Autowired
    Northeast_city northeast_city;
    @Autowired
    South_city south_city;
    @Autowired
    Southwest_city southwest_city;

    @Override
    public List<AreaVO> getNorth_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        North_city north_cit = new North_city();
        Field[] north = north_cit.getClass().getDeclaredFields();//反射华北实体类
        for (int i = 0; i < north.length; i++) {
            Field f = north[i];
        }
        for (Field f : north) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "hebei":
                    areaVO.setProvince("河北");
                    areaVO.setCity(Arrays.asList(north_city.getHebei().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "neimenggu":
                    areaVO.setProvince("内蒙古");
                    areaVO.setCity(Arrays.asList(north_city.getNeimenggu().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "shandong":
                    areaVO.setProvince("山东");
                    areaVO.setCity(Arrays.asList(north_city.getShandong().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "shanxi":
                    areaVO.setProvince("山西");
                    areaVO.setCity(Arrays.asList(north_city.getShanxi().split("、")));
                    areaVOList.add(areaVO);
                    break;

            }
        }
        System.out.println("华北地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getEast_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        East_city east_cit = new East_city();
        Field[] east = east_cit.getClass().getDeclaredFields();
        for (int i = 0; i < east.length; i++) {
            Field f = east[i];
        }
        for (Field f : east) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "anhui":
                    areaVO.setProvince("安徽");
                    areaVO.setCity(Arrays.asList(east_city.getAnhui().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "jiangsu":
                    areaVO.setProvince("江苏");
                    areaVO.setCity(Arrays.asList(east_city.getJiangsu().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "zhejiang":
                    areaVO.setProvince("浙江");
                    areaVO.setCity(Arrays.asList(east_city.getZhejiang().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "shanxi":
                    areaVO.setProvince("山西");
                    areaVO.setCity(Arrays.asList(north_city.getShanxi().split("、")));
                    areaVOList.add(areaVO);
                    break;
            }
        }
        System.out.println("华东地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getCenter_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        Center_city center_cit = new Center_city();
        Field[] center = center_cit.getClass().getDeclaredFields();
        for (int i = 0; i < center.length; i++) {
            Field f = center[i];
        }
        for (Field f : center) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "henan":
                    areaVO.setProvince("河南");
                    areaVO.setCity(Arrays.asList(center_city.getHenan().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "hubei":
                    areaVO.setProvince("湖北");
                    areaVO.setCity(Arrays.asList(center_city.getHubei().split("、")));
                    areaVOList.add(areaVO);
                    break;

            }
        }
        System.out.println("华中地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getNortheast_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        Northeast_city northeast_cit = new Northeast_city();
        Field[] northeast = northeast_cit.getClass().getDeclaredFields();
        for (int i = 0; i < northeast.length; i++) {
            Field f = northeast[i];
        }
        for (Field f : northeast) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "heilongjiang":
                    areaVO.setProvince("黑龙江");
                    areaVO.setCity(Arrays.asList(northeast_city.getHeilongjiang().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "jilin":
                    areaVO.setProvince("吉林");
                    areaVO.setCity(Arrays.asList(northeast_city.getJilin().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "liaoning":
                    areaVO.setProvince("辽宁");
                    areaVO.setCity(Arrays.asList(northeast_city.getLiaoning().split("、")));
                    areaVOList.add(areaVO);
                    break;
            }
        }
        System.out.println("东北地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getNorthwest_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        Northwest_city northwest_cit = new Northwest_city();
        Field[] northwest = northwest_cit.getClass().getDeclaredFields();//反射华北实体类
        for (int i = 0; i < northwest.length; i++) {
            Field f = northwest[i];
        }
        for (Field f : northwest) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "gansu":
                    areaVO.setProvince("甘肃");
                    areaVO.setCity(Arrays.asList(northwest_city.getGansu().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "ningxia":
                    areaVO.setProvince("宁夏");
                    areaVO.setCity(Arrays.asList(northwest_city.getNingxia().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "qinghai":
                    areaVO.setProvince("青海");
                    areaVO.setCity(Arrays.asList(northwest_city.getQinghai().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "shanxi":
                    areaVO.setProvince("陕西");
                    areaVO.setCity(Arrays.asList(northwest_city.getShanxi().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "xinjiang":
                    areaVO.setProvince("新疆");
                    areaVO.setCity(Arrays.asList(northwest_city.getXinjiang().split("、")));
                    areaVOList.add(areaVO);
                    break;

            }
        }
        System.out.println("西北地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getSouth_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        South_city south_cit = new South_city();
        Field[] south = south_cit.getClass().getDeclaredFields();//反射华北实体类
        for (int i = 0; i < south.length; i++) {
            Field f = south[i];
        }
        for (Field f : south) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "guangdong":
                    areaVO.setProvince("广东");
                    areaVO.setCity(Arrays.asList(south_city.getGuangdong().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "hunan":
                    areaVO.setProvince("湖南");
                    areaVO.setCity(Arrays.asList(south_city.getHunan().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "guangxi":
                    areaVO.setProvince("广西");
                    areaVO.setCity(Arrays.asList(south_city.getGuangxi().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "hainan":
                    areaVO.setProvince("海南");
                    areaVO.setCity(Arrays.asList(south_city.getHainan().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "fujian":
                    areaVO.setProvince("福建");
                    areaVO.setCity(Arrays.asList(south_city.getFujian().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "jiangxi":
                    areaVO.setProvince("江西");
                    areaVO.setCity(Arrays.asList(south_city.getJiangxi().split("、")));
                    areaVOList.add(areaVO);
                    break;

            }
        }
        System.out.println("华北地区加载完成");
        return areaVOList;
    }

    @Override
    public List<AreaVO> getSouthwest_city() {
        List<AreaVO> areaVOList = new ArrayList<>();
        Southwest_city southwest_cit = new Southwest_city();
        Field[] southwest = southwest_cit.getClass().getDeclaredFields();//反射华北实体类
        for (int i = 0; i < southwest.length; i++) {
            Field f = southwest[i];
        }
        for (Field f : southwest) {
            AreaVO areaVO = new AreaVO();
            switch (f.getName()) {
                case "guizhou":
                    areaVO.setProvince("贵州");
                    areaVO.setCity(Arrays.asList(southwest_city.getGuizhou().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "sichuan":
                    areaVO.setProvince("四川");
                    areaVO.setCity(Arrays.asList(southwest_city.getSichuan().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "xizang":
                    areaVO.setProvince("西藏");
                    areaVO.setCity(Arrays.asList(southwest_city.getXizang().split("、")));
                    areaVOList.add(areaVO);
                    break;
                case "yunnan":
                    areaVO.setProvince("云南");
                    areaVO.setCity(Arrays.asList(southwest_city.getYunnan().split("、")));
                    areaVOList.add(areaVO);
                    break;
            }
        }
        System.out.println("西南地区加载完成");
        return areaVOList;
    }
}
