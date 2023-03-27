package com.mall.doublerow.exception;

import cn.dev33.satoken.exception.SaTokenException;
import com.mall.doublerow.api.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName SatokenExceptionHandle
 * @Description TODO satoken全局拦截异常
 * @Date 2023/2/18 11:15
 * @Version 1.0
 */
@RestControllerAdvice
public class SatokenExceptionHandle {

    @ExceptionHandler(SaTokenException.class)
    public CommonResult handlerSaTokenException(SaTokenException e) {
        // 默认的提示
        return CommonResult.failed(e.getMessage());
    }
}
