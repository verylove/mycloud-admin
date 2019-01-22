package com.mycloud.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class AuthAccount implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 地址
     */
    private String address;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码强度
     */
    private String passStrengh;
    /**
     * 账户类型
     */
    private Integer type;
    /**
     * 账户是否启用
     */
    private boolean enabled;
    /**
     * 账户没有超时
     */
    private boolean accountNonExpired;
    /**
     * 账户是否被锁定
     */
    private boolean accountNonLocked;
    /**
     * 凭证是否超时
     */
    private boolean credentialsNonExpired;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 是否删除
     */
    private Integer isDel;

    private List<AuthRoles> roles;

    private List<MenuVo> menus;
}
