package com.goodbuy.googbuylogin.login.exception;

/**
 * @description:
 * @author: feiWoSCun
 * @Email: 2825097536@qq.com
 */
public interface ExceptionMsg {
    /**
     * @return int错误码
     */
    int code();
    /**
     *
     * @return 错误消息
     */
    String message();
}