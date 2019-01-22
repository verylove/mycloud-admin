package com.mycloud.user.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mycloud.common.model.MenuVo;
import com.mycloud.user.entity.Menus;

import java.util.List;

/**
 * <p>
 * 菜单表 接口
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
public interface IMenusService extends IService<Menus>{

    /**
     * 根据用户id查询菜单列表
     * @param id
     * @return
     */
    List<MenuVo> getMenusListByUserId(String id);
}
