package com.mycloud.common.base;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mycloud.common.constant.CommonConstant;
import com.mycloud.common.utils.SnowFlakeUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @Package com.mycloud.entity
 * @Description: 基础实体类
 * @date 2018/4/12 14:00
 */
@Data
public class BaseEntity extends Model implements Serializable {

    /**
     * 是否已删除 0：未删除 1：已删除
     */

    protected String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());;

    /*是否删除默认为0*/
    @TableLogic(value = "is_del")
    protected Integer isDel = CommonConstant.DEFAULT_DEL;

    /*创建人*/
    @TableField("create_by")
    protected String createBy;
    /*创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    protected Date createTime;

    /*修改人*/
    @TableField("update_by")
    protected String updateBy;
    /*修改时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    protected Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
