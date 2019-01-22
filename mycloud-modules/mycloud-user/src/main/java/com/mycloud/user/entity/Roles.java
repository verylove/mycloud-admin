package com.mycloud.user.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.mycloud.common.base.BaseEntity;
import com.mycloud.common.utils.SnowFlakeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 角色表
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Data
@Accessors(chain = true)
@TableName("roles")
@EqualsAndHashCode
public class Roles extends BaseEntity {

    /**
     * 角色代码
     */
	private String code;
    /**
     * 角色名称
     */
	private String name;

}
