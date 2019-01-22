package com.mycloud.common.result;

public enum ResultEnum {

    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    AUTH_ERROR("0002", "无权限"),
    SERVER_ERROR("0003", "系统服务异常"),
    LOGIN_SESSION_MISS("0004", "会话失效"),
    LOGIN_SUCCESS("0005", "登录成功"),
    LOGIN_FAIL("0006", "登录失败"),
    LOGIN_USER_ERR("0007", "用户名或密码错误"),
    LOGOUT_FAIL("0008", "注销失败"),
    TOKEN_MISS("0009","令牌缺失"),
    DATA_MISS("0010","数据为空");

    ResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}
