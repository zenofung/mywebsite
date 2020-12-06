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
@Table(name = "product")
@TableName("product")
public class Product extends Model<Product> {

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
     * 产品名称
     */
    @TableField("product_name")
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品属性（name:value,name:value...）
     */
    @TableField("attribute")
    @Column(name = "attribute")
    private String attribute;

    /**
     * 主要描述
     */
    @TableField("main_description")
    @Column(name = "main_description")
    private String mainDescription;

    /**
     * 详细描述
     */
    @Column
    @TableField("detail")
    private String detail;

    /**
     * 图片地址
     */
    @Column
    @TableField("pic")
    private String pic;

    /**
     * 产品长图
     */
    @Column
    @TableField("long_pic")
    private String longPic;

    /**
     * 关键字  多个关键字以'，'形式分开
     */
    @Column
    @TableField("keywords")
    private String keywords;

    /**
     * 功能类型id
     */
    @TableField("function_class_id")
    @Column(name = "function_class_id")
    private Integer functionClassId;

    /**
     * 产品类别  ： 智能马桶 、智能马桶盖两种
     */
    @TableField("product_class_name")
    @Column(name = "product_class_name")
    private String productClassName;


    @TableField("product_class_id")
    @Column(name = "product_class_id")
    private Integer productClassId;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getFunctionClassId() {
        return functionClassId;
    }

    public void setFunctionClassId(Integer functionClassId) {
        this.functionClassId = functionClassId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getProductClassName() {
        return productClassName;
    }

    public void setProductClassName(String productClassName) {
        this.productClassName = productClassName;
    }

    public Integer getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(Integer productClassId) {
        this.productClassId = productClassId;
    }

    public String getLongPic() {
        return longPic;
    }

    public void setLongPic(String longPic) {
        this.longPic = longPic;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }


}
