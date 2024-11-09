package com.goodbuy.googbuylogin.login;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/09
 * @Email: 2825097536@qq.com
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface LoginIdentify {

}
