package com.mall.doublerow.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.model.OmsCartItem;
import com.mall.doublerow.service.OmsCartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OmsCartItemController
 * @Date 2023/4/8 22:39
 * @Version 1.0
 */
@Api(tags = "OmsCartItemController")
@Tag(name = "OmsCartItemController",description = "购物车管理")
@RestController
@RequestMapping("cart")
public class OmsCartItemController {

    @Autowired
    private OmsCartItemService omsCartItemService;

    @ApiOperation("获取当前会员的购物车列表")
    @GetMapping("list")
    public CommonResult<List<OmsCartItem>> list() {
        List<OmsCartItem> list = omsCartItemService.list(Long.valueOf((String) StpUtil.getLoginId()));
        return CommonResult.success(list);
    }

    @ApiOperation("添加购物车")
    @PostMapping("add")
    public CommonResult<Integer> add(@RequestBody OmsCartItem omsCartItem) {
        int add = omsCartItemService.add(omsCartItem);
        if (add > 0)
            return CommonResult.success(add);
        return CommonResult.failed();
    }


}
