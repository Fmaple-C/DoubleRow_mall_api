package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonPage;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.dto.OmsOrderDetail;
import com.mall.doublerow.model.OmsOrder;
import com.mall.doublerow.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private OmsOrderService omsOrderService;

    @ApiOperation("获取用户订单列表")
    @GetMapping("list")
    public CommonResult<CommonPage<OmsOrderDetail>> list(Long memberId,
                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        CommonPage<OmsOrderDetail> omsOrderDetailCommonPage = omsOrderService.listAll(memberId, pageNum, pageSize);
        return CommonResult.success(omsOrderDetailCommonPage);
    }


}
