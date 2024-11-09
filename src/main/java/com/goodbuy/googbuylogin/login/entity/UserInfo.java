package com.goodbuy.googbuylogin.login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.Date;
import java.io.Serializable;

/**
 * (UserInfo)实体类
 *
 * @author makejava
 * @since 2024-11-09 11:50:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 459556175268068920L;

    private Long id;

    private Long role;

    private String description;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String nickname;

    private String phoneNumber;

    private String mail;

    private String password;


}

