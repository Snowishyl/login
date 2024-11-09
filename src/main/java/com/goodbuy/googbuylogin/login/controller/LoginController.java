package com.goodbuy.googbuylogin.login.controller;

import com.goodbuy.googbuylogin.login.Result;
import com.goodbuy.googbuylogin.login.entity.UserInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/09
 * @Email: 2825097536@qq.com
 * @description:
 */
@RestController
@RequestMapping("/api/goodbuy/")
@Slf4j
@Tag(name = "login", description = "登录相关")
public class LoginController {


    public Result<?> login(@RequestBody UserInfo userInfo) {
        return null;
    }

}
