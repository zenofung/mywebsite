package com.website.company.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "patent_info")
@TableName("patent_info")
public class PatentInfo extends Model<PatentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     * 专利标题
     */
    @Column
    @TableField("title")
    private String title;

    /**
     * 专利名称
     */
    @Column(name = "patent_name")
    @TableField("patent_name")
    private String patentName;

    /**
     * 专利号
     */
    @Column(name = "patent_code")
    @TableField("patent_code")
    private String patentCode;

    /**
     * 申请日期
     */
    @Column(name = "apply_date")
    @TableField("apply_date")
    private Date applyDate;

    /**
     * 专利权人
     */
    @Column(name = "patentee")
    @TableField("patentee")
    private String patentee;

    /**
     * 专利图片
     */
    @Column(name = "pic")
    @TableField("pic")
    private String pic;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentCode() {
        return patentCode;
    }

    public void setPatentCode(String patentCode) {
        this.patentCode = patentCode;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getPatentee() {
        return patentee;
    }

    public void setPatentee(String patentee) {
        this.patentee = patentee;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
