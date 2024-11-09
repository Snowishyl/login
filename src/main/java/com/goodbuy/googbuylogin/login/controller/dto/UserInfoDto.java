package com.goodbuy.googbuylogin.login.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author: feiwoscun
 * @since 2024-11-09 11:50:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 459556175268068920L;

    private String name;

    private String password;


}

