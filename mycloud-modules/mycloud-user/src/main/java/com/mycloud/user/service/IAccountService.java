package com.mycloud.user.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mycloud.user.entity.Account;
/**
 * <p>
 * 账户表 接口
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
public interface IAccountService extends IService<Account>{

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Account getAccountByUserName(String username);
}
