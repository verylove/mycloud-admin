package com.mycloud.user.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.AuthPermission;
import com.mycloud.user.service.IAuthPermissionService;
import com.mycloud.user.mapper.IAuthPermissionMapper;
/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<BaseMapper<AuthPermission>,AuthPermission> implements IAuthPermissionService{

	@Resource
	private IAuthPermissionMapper auth_permissionMapper;
	
}
