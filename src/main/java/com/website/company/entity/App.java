package com.website.company.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app")
@TableName("app")
public class App extends Model<App> {


    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @TableField("code_img")
    @Column(nullable = false)
    private String codeImg;

    @Column(name = "wechat_img")
    @TableField("wechat_img")
    private String wechatImg;


    @TableField("detail_img")
    @Column(nullable = false)
    private String detailImg;

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

    /**
     * 关键词
     */
    @Column(name = "keywords")
    @TableField("keywords")
    private String keywords;

    /**
     * 标题
     */
    @Column(name = "title")
    @TableField("title")
    private String title;

    /**
     * 描述
     */
    @Column(name = "meta_desc")
    @TableField("meta_desc")
    private String metaDesc;


    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeImg() {
        return codeImg;
    }

    public void setCodeImg(String codeImg) {
        this.codeImg = codeImg;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getWechatImg() {
        return wechatImg;
    }

    public void setWechatImg(String wechatImg) {
        this.wechatImg = wechatImg;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
