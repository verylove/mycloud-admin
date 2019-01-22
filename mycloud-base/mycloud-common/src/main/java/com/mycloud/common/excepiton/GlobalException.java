package com.mycloud.common.excepiton;

import com.mycloud.common.result.ResultEnum;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private ResultEnum resultEnum;

    public GlobalException(ResultEnum resultEnum){
        this.resultEnum=resultEnum;
    }
}
