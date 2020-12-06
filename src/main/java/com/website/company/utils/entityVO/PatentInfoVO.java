package com.website.company.utils.entityVO;

import java.util.Date;

public class PatentInfoVO {
    private Integer id;
    private String title;
    private String patentCode;
    private String applyDate;
    private String patentee;
    private String pic;
    private String patentName;

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

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

    public String getPatentCode() {
        return patentCode;
    }

    public void setPatentCode(String patentCode) {
        this.patentCode = patentCode;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
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
}
