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
@Table(name = "product_class")
@TableName("product_class")
public class ProductClass extends Model<ProductClass> {

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
     * 产品类别名称   --  智能马桶、智能马桶盖
     */
    @Column(nullable = false)
    @TableField("name")
    private String name;


    /**
     * 类别描述
     */
    @Column(nullable = false)
    @TableField("description")
    private String description;


    /**
     * 电脑Banner图片
     */
    @Column
    @TableField("pic")
    private String pic;

    /**
     * 手机banner图片
     */
    @Column(name = "mobile_banner_pic")
    @TableField("mobile_banner_pic")
    private String mobileBannerPic;

    /**
     * 手机主页图片
     */
    @Column(name = "mobile_pic")
    @TableField("mobile_pic")
    private String mobilePic;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobilePic() {
        return mobilePic;
    }

    public void setMobilePic(String mobilePic) {
        this.mobilePic = mobilePic;
    }

    public String getMobileBannerPic() {
        return mobileBannerPic;
    }

    public void setMobileBannerPic(String mobileBannerPic) {
        this.mobileBannerPic = mobileBannerPic;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
