package com.mall.doublerow.api;

public enum ResultCode implements IErrorCode{

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long status;
    private String message;

    private ResultCode(long status,String message) {
        this.status = status;
        this.message = message;
    }

    public long getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
