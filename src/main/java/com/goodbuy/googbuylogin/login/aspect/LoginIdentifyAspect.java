package com.goodbuy.googbuylogin.login.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/11
 * @Email: 2825097536@qq.com
 * @description: 权限枚举, 数字大小默认拥有小于该数字的所有权限
 * 优先级under>mustHave>anyHave
 * @see LoginIdentify
 */
@Aspect
@Slf4j
public class LoginIdentifyAspect {

    private final UserService userService;

    public LoginIdentifyAspect(UserService userService) {
        this.userService = userService;
    }


    @Before("@within(com.goodbuy.googbuylogin.login.aspect.LoginIdentify) || @annotation(com.goodbuy.googbuylogin.login.aspect.LoginIdentify)")
    public void beforeLoginIdentifyMethod(JoinPoint joinPoint) {

        if (userService == null) {
            log.error("userService is null");
            throw new NullPointerException("userService is null");
        }

        LoginIdentify loginIdentify = Optional.ofNullable(getMethodAnnotation(joinPoint)).orElse(joinPoint.getTarget().getClass().getAnnotation(LoginIdentify.class));

        if (loginIdentify == null) {
            log.error("loginIdentify is null");
            throw new NullPointerException("loginIdentify is null");
        }
        //权限去列表
        int[] anyHave = loginIdentify.anyHave();
        int[] mustHave = loginIdentify.mustHave();
        int under = loginIdentify.under();
        //用户权限
        int[] userRole = userService.getUserRole();
        if (Arrays.stream(userRole).max().orElse(Integer.MAX_VALUE) < under) {
            log.info("userRole[]<under,通过校验");
            return;
        }
        if (Arrays.equals(userRole, mustHave)) {
            log.info("userRole==mustHave,校验通过");
            return;
        }
        if (this.ifHaveIntersection(anyHave, userRole)) {
            log.info("anyHave contain userRole,校验通过");
        }

        if (log.isErrorEnabled()) {
            log.error("用户鉴权未通过,当前用户权限{}，mustHave{}，anyHave{}，under{}，",
                    userRole, mustHave, anyHave, under);
        }


        throw new RuntimeException("权限未通过");
    }

    /*
    交集
     */
    private boolean ifHaveIntersection(int[] userRole, int[] mustHave) {
        for (int j : userRole) {
            for (int k : mustHave) {
                if (j == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 获取方法上的 LoginIdentify 注解
    private LoginIdentify getMethodAnnotation(JoinPoint joinPoint) {
        try {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            return method.getAnnotation(LoginIdentify.class);
        } catch (Exception e) {
            return null;
        }
    }
}
