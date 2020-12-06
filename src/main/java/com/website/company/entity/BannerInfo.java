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
 * Banner区域的活动实体
 */
@Entity
@Table(name = "banner_info")
@TableName("banner_info")
public class BannerInfo extends Model<BannerInfo> {


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


    @Column
    @TableField("report_title")
    private String reportTitle;

    @Column
    @TableField("report")
    private String report;

    @Column
    @TableField("activity_title")
    private String activityTitle;

    @Column
    @TableField("activity")
    private String activity;

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

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
