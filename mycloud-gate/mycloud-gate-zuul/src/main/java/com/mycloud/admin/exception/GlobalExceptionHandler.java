package com.mycloud.admin.exception;

import com.mycloud.common.excepiton.BusinessExcpetion;
import com.mycloud.common.result.Result;
import com.mycloud.common.result.ResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常拦截
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result accessDeniedException(HttpServletRequest request, Exception e){
        if(e instanceof AccessDeniedException){
            return Result.returnFail(ResultEnum.AUTH_ERROR);
        }
        return Result.returnFail(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = BusinessExcpetion.class)
    public Result<BusinessExcpetion> handle(BusinessExcpetion e) {
        return Result.returnFail(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public Result handle(HttpClientErrorException e) {
        return Result.returnFail(com.mycloud.common.enums.ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpServerErrorException.class)
    public Result handle(HttpServerErrorException e) {
        return Result.returnFail(com.mycloud.common.enums.ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(value = UnknownHttpStatusCodeException.class)
    public Result handle(UnknownHttpStatusCodeException e) {
        return Result.returnFail(com.mycloud.common.enums.ResultEnum.SERVER_ERROR);
    }

}
