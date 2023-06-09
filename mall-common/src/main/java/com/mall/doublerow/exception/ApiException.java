package com.mall.doublerow.exception;

import com.mall.doublerow.api.IErrorCode;

/**
 * @ClassName ApiException
 * @Description TODO 自定义API异常
 * @Date 2023/2/17 21:04
 * @Version 1.0
 */
public class ApiException extends RuntimeException{

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

}
