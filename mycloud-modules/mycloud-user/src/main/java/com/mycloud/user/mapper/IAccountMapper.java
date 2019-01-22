package com.mycloud.user.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mycloud.user.entity.Account;
import com.mycloud.user.entity.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 账户表 Mapper 接口
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
public interface IAccountMapper extends BaseMapper<Account>{
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    Account getAccountByUserName(@Param("username") String username);

    List<Roles> getRolesByAccountId();
}