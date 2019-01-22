package com.mycloud.user.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycloud.common.model.MenuVo;
import com.mycloud.user.entity.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
public interface IMenusMapper extends BaseMapper<Menus>{

    List<MenuVo> getMenusListByUserId(@Param("id") String id);
}