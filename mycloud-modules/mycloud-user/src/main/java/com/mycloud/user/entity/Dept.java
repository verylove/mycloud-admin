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
 * 
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Data
@Accessors(chain = true)
@TableName("dept")
public class Dept extends BaseEntity{

    private static final long serialVersionUID = 1L;

	private String name;
	private Integer enable;



}
