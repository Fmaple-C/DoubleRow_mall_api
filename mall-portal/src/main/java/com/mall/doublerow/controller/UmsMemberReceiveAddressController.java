package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.model.UmsMemberReceiveAddress;
import com.mall.doublerow.service.UmsMemberReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UmsMemberReceiveAddressController
 * @Description TODO
 * @Date 2023/4/10 21:37
 * @Version 1.0
 */
@Api(tags = "UmsMemberReceiveAddressController")
@Tag(name = "UmsMemberReceiveAddressController",description = "用户地址管理")
@RestController
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {

    @Autowired
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @ApiOperation("增加用户地址")
    @PostMapping("add")
    public CommonResult add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){
        int add = umsMemberReceiveAddressService.add(umsMemberReceiveAddress);
        if (add > 0)
            return CommonResult.success(add);
        return CommonResult.failed();
    }

    @ApiOperation("返回当前用户的收货地址")
    @GetMapping("list")
    public CommonResult<List<UmsMemberReceiveAddress>> list() {
        return CommonResult.success(umsMemberReceiveAddressService.list());
    }

    @ApiOperation("返回当前用户的收货地址")
    @GetMapping("getItem")
    public CommonResult<UmsMemberReceiveAddress> getItem(Long id) {
        return CommonResult.success(umsMemberReceiveAddressService.getItem(id));
    }

}
