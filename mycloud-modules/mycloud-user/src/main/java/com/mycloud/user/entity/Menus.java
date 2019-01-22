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
 * 菜单表
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Data
@Accessors(chain = true)
@TableName("menus")
public class Menus extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
	private String name;
    /**
     * 菜单代码
     */
	private String code;
    /**
     * 菜单路径
     */
	private String path;
    /**
     * vue加载路径
     */
	private String component;
    /**
     * 菜单图标
     */
	private String icon;
    /**
     * 菜单标题（英文）
     */
	private String title;
    /**
     * 是否隐藏
     */
	private boolean hidden;
    /**
     * 重定向地址
     */
	private String redirect;
    /**
     * 是否展示
     */
	@TableField("always_show")
	private boolean alwaysShow;
    /**
     * 是否启用
     */
	private boolean enabled;
    /**
     * 是否缓存
     */
	private boolean keepalived;
    /**
     * 父节点id
     */
	@TableField("parent_id")
	private String parentId;

	private List<Menus> children;

}
