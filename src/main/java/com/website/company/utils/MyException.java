package com.website.company.utils;

/**
 * @Author: Peng Yangyan
 * @CreateDate: Created in 2018/11/23 9:19
 * @Description: 自定义异常
 */
public class MyException extends RuntimeException {


    public MyException() {
    }

    public MyException(String msg) {
        this.msg = msg;
    }

    /**
     * 异常信息
     */
    private String msg;

    /**
     * 具体异常码
     */
    private int code = Code.FAILED;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
