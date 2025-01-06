package com.goodbuy.googbuylogin.login;


import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserRepository {
    Optional<UserInfoDto> findByUsername(String username);

    void save(UserInfoDto user);

    void deleteByUsername(String username);

}
