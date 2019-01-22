package com.mycloud.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.mycloud.common.result.ResultEnum;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Result <T> implements Serializable {

    private String code;

    private String message;

    private T data;


    //不带返回数据的成功
    public static <T> Result<T> returnSuccess() {
        return new Result<T>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getDesc());
    }

    //带返回数据的成功
    public static <T> Result<T> returnSuccess(T t) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), t);
    }
    //带返回参数
    public static <T> Result<T> returnSuccess(ResultEnum resultEnum,T t) {
        return new Result<T>(resultEnum.getCode(),resultEnum.getDesc(),t);
    }

    //不带具体错误信息的错误
    public static <T> Result<T> returnFail() {
        return new Result<T>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getDesc());
    }

    //带返回信息的错误
    public static <T> Result<T> returnFail(ResultEnum resultEnum) {
        return new Result<T>(resultEnum.getCode(), resultEnum.getDesc());
    }

    //带数据的错误
    public static <T> Result<T> returnFail(T t) {
        return new Result<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getDesc(), t);
    }




    private Result(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getDesc();
    }


    private Result(String code, String desc, T data) {
        this.code = code;
        this.message = desc;
        this.data = data;
    }
    private Result(String code, String desc) {
        this.code = code;
        this.message = desc;
    }
    private Result(ResultEnum resultEnum,T data){
        this.code = "0000";
        this.message = resultEnum.getDesc();
        this.data=data;
    }

}
