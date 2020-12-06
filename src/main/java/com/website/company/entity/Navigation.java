package com.website.company.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "navigation")
@TableName("navigation")
public class Navigation extends Model<Navigation> {

    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField("create_datetime")
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDatetime;

    /**
     * 修改时间
     */
    @TableField("update_datetime")
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDatetime;
    /**
     * 导航名称
     */
    @TableField("nav_name")
    @Column(name = "nav_name")
    private String navName;

    /**
     * 分站Title
     */
    @TableField("div_name")
    @Column(name = "div_name")
    private String divName;

    /**
     * 分站描述
     */
    @TableField("div_desc")
    @Column(name = "div_desc")
    private String divDesc;


    /**
     * 导航描述
     */
    @TableField("nav_desc")
    @Column(name = "nav_desc")
    private String navDesc;

    @TableField("nav_keywords")
    @Column(name = "nav_keywords")
    private String navKeywords;

    @TableField("nav_title")
    @Column(name = "nav_title")
    private String navTitle;

    /**
     * 导航地址
     */
    @TableField("nav_url")
    @Column(name = "nav_url")
    private String navUrl;

    /**
     * 导航层级
     */
    @TableField("nav_level")
    @Column(name = "nav_level", columnDefinition = "int(11) default 1")
    private Integer navLevel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public String getNavDesc() {
        return navDesc;
    }

    public void setNavDesc(String navDesc) {
        this.navDesc = navDesc;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }

    public Integer getNavLevel() {
        return navLevel;
    }

    public void setNavLevel(Integer navLevel) {
        this.navLevel = navLevel;
    }


    public String getNavKeywords() {
        return navKeywords;
    }

    public void setNavKeywords(String navKeywords) {
        this.navKeywords = navKeywords;
    }

    public String getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName;
    }

    public String getDivDesc() {
        return divDesc;
    }

    public void setDivDesc(String divDesc) {
        this.divDesc = divDesc;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
