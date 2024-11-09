package com.goodbuy.googbuylogin.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/7/15
 * @Email: 2825097536@qq.com
 */
@AllArgsConstructor
@Getter
public enum ExceptionEnums implements ExceptionMsg {
    SYSTEM_FAIL(-1, "程序内部异常"),
    PARAM_EXCEPTION(-2, "参数校验错误"),
    COMPUTE_FAIL(-3, "计算错误"),
    NULL_POINTER_EXCEPTION(-4, "空指针异常"),
    ZERO(-5, "分母不能为0！");
    public static final String TEXT_HTML_CHARSET_UTF_8 = "text/html;charset=utf-8";
    private final int code;
    private final String message;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}