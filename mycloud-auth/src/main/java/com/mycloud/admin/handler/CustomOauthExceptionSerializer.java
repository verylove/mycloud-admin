package com.mycloud.admin.handler;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mycloud.common.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author huangqi
 * @Package com.mycloud.cloud.oauth2server.handler
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2018/6/27 16:22
 */
@Component
public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
    public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Result result = new Result();
        result.setCode(String.valueOf(value.getHttpErrorCode()));
        result.setMessage(value.getMessage());
        gen.writeObject(result);
    }
}

