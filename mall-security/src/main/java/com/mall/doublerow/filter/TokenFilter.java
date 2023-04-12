package com.mall.doublerow.filter;

import com.alibaba.fastjson.JSON;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.api.ResultCode;
import com.mall.doublerow.exception.ApiException;
import com.mall.doublerow.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Date 2023/4/12 15:30
 * @Version 1.0
 */
@Component
public class TokenFilter implements HandlerInterceptor {

    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断
     （如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println(token);
        if (null == token||"".equals(token)) {
            throw new ApiException(ResultCode.UNAUTHORIZED);
        }
        try {
            JwtUtils.parseJWT(token);
            return true;
        } catch (Exception e) {
           throw new ApiException(ResultCode.FORBIDDEN);
        }
    }


}
