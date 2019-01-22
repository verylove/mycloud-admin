package com.mycloud.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
public class IpLocate implements Serializable {

    private String retCode;

    private City result;
}

