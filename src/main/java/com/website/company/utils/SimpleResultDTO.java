package com.website.company.utils;

/**
 * @Author: Peng Yangyan
 * @CreateDate: Created in 2018/8/10 0:28
 * @Description:
 */
public class SimpleResultDTO {
    private boolean status;
    private String reason;
    private Object detail;

    public SimpleResultDTO() {
    }

    public SimpleResultDTO(Object detail) {
        this.status = true;
        this.reason = "操作成功";
        this.detail = detail;
    }

    public SimpleResultDTO(boolean status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
