package com.mycloud.user.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mycloud.user.entity.Account;
import com.mycloud.user.service.IAccountService;
import com.mycloud.user.mapper.IAccountMapper;
/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@Service
public class AccountServiceImpl extends ServiceImpl<BaseMapper<Account>,Account> implements IAccountService{

	@Resource
	private IAccountMapper accountMapper;

	/**
	 * 根据用户名查询用户
	 *
	 * @param username
	 * @return
	 */
	@Override
	public Account getAccountByUserName(String username) {

		return accountMapper.getAccountByUserName(username);
	}
}
