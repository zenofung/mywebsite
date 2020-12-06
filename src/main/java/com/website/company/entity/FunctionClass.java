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

/**
 * 产品功能
 */
@Entity
@Table(name = "function_class")
@TableName("function_class")
public class FunctionClass extends Model<FunctionClass> {

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
     * 功能类型名称
     */
    @Column(name = "function_class_name")
    @TableField("function_class_name")
    private String functionClassName;

    /**
     * 英文名称
     */
    @Column(name = "english_name")
    @TableField("english_name")
    private String englishName;

    /**
     * 功能描述
     */
    @Column
    @TableField("description")
    private String description;

    /**
     * 图片地址
     */
    @Column
    @TableField("pic")
    private String pic;

    /**
     * 移动端图片
     */
    @Column
    @TableField("mobile_pic")
    private String mobilePic;


    /**
     * banner图片
     */
    @Column
    @TableField("icon")
    private String icon;


    @Column(name = "product_name")
    @TableField("product_name")
    private String productName;

    /**
     * 图标图片
     */
    @Column(name = "icon_pc")
    @TableField("icon_pc")
    private String iconPc;

    /**
     * 类别code  1--可点击的类别 2--不能点击的基础功能
     **/
    @Column(columnDefinition = "int(11) default 1")
    @TableField("class_code")
    private Integer classCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getFunctionClassName() {
        return functionClassName;
    }

    public void setFunctionClassName(String functionClassName) {
        this.functionClassName = functionClassName;
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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getClassCode() {
        return classCode;
    }

    public void setClassCode(Integer classCode) {
        this.classCode = classCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMobilePic() {
        return mobilePic;
    }

    public void setMobilePic(String mobilePic) {
        this.mobilePic = mobilePic;
    }

    public String getIconPc() {
        return iconPc;
    }

    public void setIconPc(String iconPc) {
        this.iconPc = iconPc;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
