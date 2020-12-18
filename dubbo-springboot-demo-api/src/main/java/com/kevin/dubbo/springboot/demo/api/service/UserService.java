package com.kevin.dubbo.springboot.demo.api.service;

import com.kevin.dubbo.springboot.demo.api.bean.UserAddress;

import java.util.List;

/**
 * create by kevin.
 * @author Kevin
 * @Date 2020/10/27
 */
public interface UserService {
    /**
     * 查询用户信息
     * @param userId 用户id
     * @return 用户数据集合
     */
    public List<UserAddress> getUserAddressList(String userId);
}
