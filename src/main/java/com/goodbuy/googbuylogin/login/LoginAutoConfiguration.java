package com.goodbuy.googbuylogin.login;

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
public class LoginAutoConfiguration {


    @Bean
    @ConditionalOnBean(UserService.class)
    public LoginIdentifyAspect getLoginIdentifyAspect(UserService userService) {
        return new LoginIdentifyAspect(userService);
    }


}