package com.mycloud.user.controller;


import com.mycloud.common.result.Result;
import com.mycloud.user.service.IRolesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author HOU
 * @since 2019-01-15
 */
@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {
    private final IRolesService rolesService;

    @GetMapping(value = "/roles")
    public Result getRoles(){

        return Result.returnSuccess();
    }

	
}
