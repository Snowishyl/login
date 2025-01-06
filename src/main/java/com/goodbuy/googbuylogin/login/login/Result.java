package com.goodbuy.googbuylogin.login.login;



import com.goodbuy.googbuylogin.login.login.exception.ExceptionMsg;

import java.io.Serializable;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/11/6
 * @Email: 2825097536@qq.com
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 12414L;

    private Boolean ifSuccess;
    protected Integer code;
    private String msg;
    protected T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setData(null);
        result.setIfSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setMsg("success");
        result.setIfSuccess(Boolean.TRUE);
        result.setCode(200);
        return result;
    }


    public static <T> Result<T> fail(ExceptionMsg errorEnum) {
        Result<T> result = new Result<>();
        result.setIfSuccess(Boolean.FALSE);
        result.setCode(errorEnum.code());
        result.setMsg(errorEnum.message());
        return result;
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<T>();
        result.setIfSuccess(Boolean.FALSE);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Boolean getIfSuccess() {
        return ifSuccess;
    }

    public void setIfSuccess(Boolean ifSuccess) {
        this.ifSuccess = ifSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}