package com.mycloud.admin.handler;

import com.mycloud.common.result.Result;
import com.mycloud.common.utils.ResponseUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @Package com.mycloud.cloud.oauth2server.handler
 * @Description: UnAccessDeniedHandler
 * @date 2018/4/19 10:29
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    /**
     * 授权失败(forbidden)时返回信息
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //返回json形式的错误信息
        ResponseUtil.out(httpServletResponse, Result.returnFail("未授权"));

    }
}
