package com.mycloud.user.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.AccountRoles;
import com.mycloud.user.service.IAccountRolesService;
import com.mycloud.user.mapper.IAccountRolesMapper;
/**
 * <p>
 * 账户角色表 服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-22
 */
@Service
public class AccountRolesServiceImpl extends ServiceImpl<BaseMapper<AccountRoles>,AccountRoles> implements IAccountRolesService{

	@Resource
	private IAccountRolesMapper accountRolesMapper;
	
}
