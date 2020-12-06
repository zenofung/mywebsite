package com.website.company.utils;

import java.io.Serializable;
import java.util.List;

public class ResponseList<T> implements Serializable {
    /**
     * 返回列表
     */
    private List<T> result;
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 返回条数
     */
    private Integer rows;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 响应码
     */
    private Integer code;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
