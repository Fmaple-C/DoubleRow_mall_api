package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OmsOrderController
 * @Date 2023/4/11 23:32
 * @Version 1.0
 */
@Api(tags = "OmsOrderController")
@Tag(name = "OmsOrderController" ,description = "用户订单管理")
@RestController
@RequestMapping("order")
public class OmsOrderController {

    @GetMapping("list")
    public CommonResult list(){

        return null;
    }
}
