package com.mycloud.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.mycloud.common.model.AuthAccount;
import com.mycloud.common.model.AuthRoles;
import com.mycloud.common.model.MenuVo;
import com.mycloud.common.result.Result;
import com.mycloud.common.utils.ObjectConvertUtil;
import com.mycloud.user.entity.Account;
import com.mycloud.user.entity.Roles;
import com.mycloud.user.service.IAccountService;
import com.mycloud.user.service.IMenusService;
import com.mycloud.user.utils.MenuVoTreeUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 账户表 前端控制器
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final IAccountService accountService;
    private final IMenusService menusService;

    @PostMapping(value = "/getUserByUsername")
    public Result<AuthAccount> getUserByUsername(AuthAccount authAccount){
        Account account = accountService.getAccountByUserName(authAccount.getUsername());
        return Result.returnSuccess(ObjectConvertUtil.convert(account, AuthAccount.class));
    }
    @PostMapping(value = "/info")
    public Result<AuthAccount> authAccountResult(){

        List<MenuVo> menuVoList = menusService.getMenusListByUserId("97510994686775329");
        MenuVoTreeUtil menuVoTreeUtil = new MenuVoTreeUtil();
        List<MenuVo> menus = menuVoTreeUtil.menusList(menuVoList);
        MenuVo page404 = new MenuVo();
        page404.setPath("*");
        page404.setRedirect("/404");
        page404.setHidden(true);
        menus.add(page404);
        AuthAccount account = new AuthAccount();
        AuthRoles authRoles = new AuthRoles();
        authRoles.setCode("ROLE_USER");
        authRoles.setName("管理员");
        List<AuthRoles> list = new ArrayList<>();
        list.add(authRoles);
        account.setRoles(list);
        account.setMenus(menus);
        return Result.returnSuccess(account);
    }
}
