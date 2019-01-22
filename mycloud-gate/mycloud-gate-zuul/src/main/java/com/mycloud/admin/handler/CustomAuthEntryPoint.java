package com.mycloud.admin.handler;

import com.mycloud.common.entity.Result;
import com.mycloud.common.enums.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mycloud
 * @Package com.mycloud.cloud.oauth2server.handler
 * @Description: UnauthorizedHandler
 * @date 2018/4/19 10:22
 */
@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
    /**
     * 自定义EntryPoint用于tokan校验失败返回信息
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json形式的错误信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        Result result = new Result(ResultEnum.LOGIN_SESSION_MISS);
        httpServletResponse.getWriter().print(result.toString());
        httpServletResponse.getWriter().flush();

    }
}
