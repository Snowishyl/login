package com.goodbuy.googbuylogin.login.login;

import lombok.NonNull;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/11
 * @Email: 2825097536@qq.com
 * @description: 得到用户信息的接口，项目中应该引入后自己实现
 */
public interface UserService {
    /**
     * 得到用户权限对应的数值
     *
     * @return 用户
     */
    int[] getUserRole();

    /**
     * @param permissions 权限大小
     * @return 是否通过鉴权
     */
   default boolean ifPass(@NonNull Permissions permissions){
       return true;
   }

}
