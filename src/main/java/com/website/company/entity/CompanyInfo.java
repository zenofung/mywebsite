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
 * 关于我们（公司信息）
 */
@Entity
@Table(name = "company_info")
@TableName("company_info")
public class CompanyInfo extends Model<CompanyInfo> {

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
     * 公司名称
     */
    @Column(name = "company_name")
    @TableField("company_name")
    private String companyName;

    /**
     * 公司宗旨
     */
    @Column(name = "company_purpose")
    @TableField("company_purpose")
    private String companyPurpose;

    /**
     * 公司描述
     */
    @Column
    @TableField("description")
    private String description;

    /**
     * 发展历程背景图
     */
    @Column(name = "dev_pic")
    @TableField("dev_pic")
    private String devPic;

    /**
     * 发展背景图手机端
     */
    @Column(name = "dev_phone_pic")
    @TableField("dev_phone_pic")
    private String devPhonePic;

    /**
     * 业务范围
     */
    @Column(name = "working_range")
    @TableField("working_range")
    private String workingRange;

    /**
     * 业务背景图
     */
    @Column(name = "work_range_pic")
    @TableField("work_range_pic")
    private String workingRangePic;

    /**
     * 研发团队
     */
    @Column
    @TableField("team")
    private String team;

    /**
     * 公司领导
     */
    @Column
    @TableField("leader")
    private String leader;

    /**
     * 业务团队
     */
    @Column(name = "work_team")
    @TableField("work_team")
    private String workTeam;


    /**
     * 公司管理
     */
    @Column(name = "company_manage")
    @TableField("company_manage")
    private String companyManage;


    /**
     * 三大管理程序
     */
    @Column(name = "manage_info")
    @TableField("manage_info")
    private String manageInfo;

    /**
     * 企业文化Title
     */
    @Column(name = "company_culture_title")
    @TableField("company_culture_title")
    private String companyCultureTitle;

    /**
     * 企业文化
     */
    @Column(name = "company_culture")
    @TableField("company_culture")
    private String companyCulture;

    /**
     * 联系人id
     */
    @Column(name = "link_man_id")
    @TableField("link_man_id")
    private Integer linkManId;

    /**
     * Banner公告
     * 招商信息题目
     */
    @Column(name = "attract_title")
    @TableField("attract_title")
    private String attractTitle;

    /**
     * 招商内容
     */
    @Column(name = "attract_content")
    @TableField("attract_content")
    private String attractContent;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getMobileBannerPic() {
        return mobileBannerPic;
    }

    public void setMobileBannerPic(String mobileBannerPic) {
        this.mobileBannerPic = mobileBannerPic;
    }

    public String getDevPhonePic() {
        return devPhonePic;
    }

    public void setDevPhonePic(String devPhonePic) {
        this.devPhonePic = devPhonePic;
    }

    public String getWorkingRangePic() {
        return workingRangePic;
    }

    public void setWorkingRangePic(String workingRangePic) {
        this.workingRangePic = workingRangePic;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getWorkTeam() {
        return workTeam;
    }

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam;
    }

    public String getCompanyCultureTitle() {
        return companyCultureTitle;
    }

    public void setCompanyCultureTitle(String companyCultureTitle) {
        this.companyCultureTitle = companyCultureTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPurpose() {
        return companyPurpose;
    }

    public void setCompanyPurpose(String companyPurpose) {
        this.companyPurpose = companyPurpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLinkManId() {
        return linkManId;
    }

    public void setLinkManId(Integer linkManId) {
        this.linkManId = linkManId;
    }

    public String getWorkingRange() {
        return workingRange;
    }

    public void setWorkingRange(String workingRange) {
        this.workingRange = workingRange;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCompanyManage() {
        return companyManage;
    }

    public void setCompanyManage(String companyManage) {
        this.companyManage = companyManage;
    }

    public String getManageInfo() {
        return manageInfo;
    }

    public void setManageInfo(String manageInfo) {
        this.manageInfo = manageInfo;
    }

    public String getCompanyCulture() {
        return companyCulture;
    }

    public void setCompanyCulture(String companyCulture) {
        this.companyCulture = companyCulture;
    }

    public String getDevPic() {
        return devPic;
    }

    public void setDevPic(String devPic) {
        this.devPic = devPic;
    }

    public String getAttractTitle() {
        return attractTitle;
    }

    public void setAttractTitle(String attractTitle) {
        this.attractTitle = attractTitle;
    }

    public String getAttractContent() {
        return attractContent;
    }

    public void setAttractContent(String attractContent) {
        this.attractContent = attractContent;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
