package com.mycloud.user.service.impl;
import javax.annotation.Resource;

import com.mycloud.common.model.MenuVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.Menus;
import com.mycloud.user.service.IMenusService;
import com.mycloud.user.mapper.IMenusMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Service
public class MenusServiceImpl extends ServiceImpl<BaseMapper<Menus>,Menus> implements IMenusService{

	@Resource
	private IMenusMapper menusMapper;

	/**
	 * 根据用户id查询菜单列表
	 *
	 * @param id
	 * @return
	 */
	@Override
	public List<MenuVo> getMenusListByUserId(String id) {
		return menusMapper.getMenusListByUserId(id);
	}
}
