package com.mycloud.user.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.Roles;
import com.mycloud.user.service.IRolesService;
import com.mycloud.user.mapper.IRolesMapper;
/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Service
public class RolesServiceImpl extends ServiceImpl<BaseMapper<Roles>,Roles> implements IRolesService{

	@Resource
	private IRolesMapper rolesMapper;
	
}
