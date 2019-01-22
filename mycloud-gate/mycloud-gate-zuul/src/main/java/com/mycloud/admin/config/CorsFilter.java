package com.mycloud.admin.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {
    static final String ORIGIN = "Origin";
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
            String origin = request.getHeader(ORIGIN);
            logger.debug("过滤可执行的方法。。。");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers",
                "User-Agent,Origin,Cache-Control,Content-type,Date,Server,withCredentials,accesstoken,lf-None-Matoh,Authorization");
        response.setHeader("Access-Control-Max-Age", "1209600");
        response.setHeader("Access-Control-Expose-Headers", "lf-None-Matoh");
        response.setHeader("Access-Control-Request-Headers", "lf-None-Matoh");
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
            if (request.getMethod().equals("OPTIONS"))
                response.setStatus(HttpServletResponse.SC_OK);
            else
                filterChain.doFilter(request, response);
    }
}
