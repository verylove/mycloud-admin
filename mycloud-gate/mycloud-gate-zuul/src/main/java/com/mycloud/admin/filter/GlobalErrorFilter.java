package com.mycloud.admin.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;

/**
 * @author houqijun
 * @Description: 当链路调用异常时，进入的过滤器
 * @date 2018/4/23 14:33
 */
@Slf4j
public class GlobalErrorFilter  extends ZuulFilter {

    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        log.error("[ErrorFilter] error message: {}", throwable.getCause().getMessage());
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.exception", throwable.getCause());
        return null;
    }

}
