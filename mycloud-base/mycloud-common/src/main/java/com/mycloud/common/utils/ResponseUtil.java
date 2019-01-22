package com.mycloud.common.utils;

import com.google.gson.Gson;
import com.mycloud.common.result.Result;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
@Slf4j
public class ResponseUtil {

    public static void out(HttpServletResponse response, Result result){
        PrintWriter out = null;
        Gson gson = new Gson();
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(new Gson().toJson(result));
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }

    }

}
