package com.mycloud.user.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mycloud.common.base.BaseEntity;
import com.mycloud.common.utils.SnowFlakeUtil;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * <p>
 * 账户表
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Data
@Accessors(chain = true)
@TableName("account")
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
	@TableField("dept_id")
	private Integer deptId;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 密码强度
     */
	@TableField("pass_strengh")
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
	@TableField("account_non_expired")
	private boolean accountNonExpired;
    /**
     * 账户是否被锁定
     */
	@TableField("account_non_locked")
	private boolean accountNonLocked;
    /**
     * 凭证是否超时
     */
	@TableField("credentials_non_expired")
	private boolean credentialsNonExpired;

	private List<Roles> roles;

}
