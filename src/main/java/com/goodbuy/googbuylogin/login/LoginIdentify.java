package com.goodbuy.googbuylogin.login;

import org.springframework.stereotype.Service;

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
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface LoginIdentify {
    /**
     *
     * @return 必须要有的权限
     */
    int[] mustHave() default {0};

    /**
     *
     * @return 有任意一个就pass
     */
    int[] anyHave() default 0;

    /**
     *
     * @return 小于某个值就同行
     */
    int under() default 0;

    boolean ifPass() default true;
}
