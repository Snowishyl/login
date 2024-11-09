package com.goodbuy.googbuylogin.service;

import com.goodbuy.googbuylogin.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (UserInfo)表服务接口
 *
 * @author makejava
 * @since 2024-11-09 11:50:32
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Long id);

    /**
     * 分页查询
     *
     * @param userInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserInfo> queryByPage(UserInfo userInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo update(UserInfo userInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
