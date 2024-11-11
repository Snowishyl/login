package com.goodbuy.googbuylogin;

import com.goodbuy.googbuylogin.login.LoginIdentifyAspect;
import com.goodbuy.googbuylogin.login.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/11
 * @Email: 2825097536@qq.com
 * @description:
 */
@EnableConfigurationProperties
@Import(com.goodbuy.googbuylogin.login.LoginIdentifyAspect.class)
public class LoginAutoConfiguration {


    @Bean
    @ConditionalOnBean(UserService.class)
    public LoginIdentifyAspect getLoginIdentifyAspect(UserService userService) {
        return new LoginIdentifyAspect(userService);
    }


}
