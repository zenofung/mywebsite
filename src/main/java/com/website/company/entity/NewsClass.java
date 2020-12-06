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
@Table(name = "news_class")
@TableName("news_class")
public class NewsClass extends Model<NewsClass> {

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
    @Column(nullable = false)
    @TableField("create_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDatetime;

    /**
     * 修改时间
     */
    @Column(nullable = false)
    @TableField("update_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDatetime;
    /**
     * 新闻类别名称
     */
    @Column(name = "news_class_name")
    @TableField("news_class_name")
    private String newsClassName;

    /**
     * 描述
     */
    @Column
    @TableField("description")
    private String description;

    /**
     * 关键词
     */
    @Column
    @TableField("keywords")
    private String keywords;

    /**
     * 手机主页图片
     */
    @Column
    @TableField("mobile_pic")
    private String mobilePic;

    /**
     * 电脑主页图片
     */
    @Column
    @TableField("pic")
    private String pic;

    /**
     * 电脑banner图片
     */
    @Column(name = "banner_pic")
    @TableField("banner_pic")
    private String bannerPic;

    /**
     * 手机banner图片
     */
    @Column(name = "mobile_banner_pic")
    @TableField("mobile_banner_pic")
    private String mobileBannerPic;


    public String getMobilePic() {
        return mobilePic;
    }

    public void setMobilePic(String mobilePic) {
        this.mobilePic = mobilePic;
    }

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

    public String getNewsClassName() {
        return newsClassName;
    }

    public void setNewsClassName(String newsClassName) {
        this.newsClassName = newsClassName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public String getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(String bannerPic) {
        this.bannerPic = bannerPic;
    }

    public String getMobileBannerPic() {
        return mobileBannerPic;
    }

    public void setMobileBannerPic(String mobileBannerPic) {
        this.mobileBannerPic = mobileBannerPic;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
