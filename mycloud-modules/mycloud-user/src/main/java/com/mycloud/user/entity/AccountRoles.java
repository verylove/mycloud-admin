package com.mycloud.user.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import com.mycloud.common.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * <p>
 * 账户角色表
 * </p>
 *
 * @author HOU
 * @since 2019-01-22
 */
@Data
@Accessors(chain = true)
@TableName("account_roles")
public class AccountRoles extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
	private String aid;
    /**
     * 角色id
     */
	private String rid;



}
