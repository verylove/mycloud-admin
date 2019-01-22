package com.mycloud.user.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.mycloud.common.base.BaseEntity;
import com.mycloud.common.utils.SnowFlakeUtil;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * <p>
 * 权限表
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Data
@Accessors(chain = true)
@TableName("auth_permission")
public class AuthPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 拦截路径
     */
	@TableField("url_pattern")
	private String urlPattern;
    /**
     * 权限名称
     */
	private String name;
    /**
     * 菜单id
     */
	private Long mid;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
