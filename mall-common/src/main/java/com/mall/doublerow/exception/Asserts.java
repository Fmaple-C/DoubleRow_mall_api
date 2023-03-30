package com.mall.doublerow.exception;

import com.mall.doublerow.api.IErrorCode;

/**
 * @ClassName Asserts
 * @Description TODO 断言处理类，用于抛出各种API异常
 * @Date 2023/2/17 21:06
 * @Version 1.0
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
