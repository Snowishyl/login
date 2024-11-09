package com.goodbuy.googbuylogin.controller;

import com.goodbuy.googbuylogin.Result;
import lombok.extern.slf4j.Slf4j;
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
public class LoginController {


    public Result<?> login(String username, String password) {
        return null;
    }

}
