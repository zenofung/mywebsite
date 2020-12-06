package com.website.company.utils;

import java.io.Serializable;

/**
 * @Author: Peng Yangyan
 * @CreateDate: Created in 2018/11/23 9:07
 * @Description: 定义接口返回响应实体
 */
public class Response<T> implements Serializable {
    /**
     * 返回结果集
     */
    private T result;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 响应码
     */
    private Integer code;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
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
}
