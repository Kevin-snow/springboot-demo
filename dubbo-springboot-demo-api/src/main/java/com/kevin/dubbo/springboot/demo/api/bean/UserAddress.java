package com.kevin.dubbo.springboot.demo.api.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * create by kevin.
 * @author Kevin
 * @Date 2020/10/27
 */
@Data
public class UserAddress implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String phone;
    /**
     * 是否默认地址
     */
    private boolean isDefault;
}
