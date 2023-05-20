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
    public CommonResult<List<UmsMemberReceiveAddress>> list(Long memberId) {
        return CommonResult.success(umsMemberReceiveAddressService.list(memberId));
    }

    @ApiOperation("返回当前用户的收货地址详情")
    @GetMapping("getItem")
    public CommonResult<UmsMemberReceiveAddress> getItem(Long id,Long memberId) {
        return CommonResult.success(umsMemberReceiveAddressService.getItem(id,memberId));
    }

    @ApiOperation("修改用户地址")
    @PutMapping("update")
    public CommonResult update(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress){
        boolean b = umsMemberReceiveAddressService.updateById(umsMemberReceiveAddress);
        return b ? CommonResult.success("修改成功") : CommonResult.failed();
    }

    @ApiOperation("删除用户地址")
    @DeleteMapping("delete")
    public CommonResult delete(@RequestBody Long id){
        boolean b = umsMemberReceiveAddressService.removeById(id);
        return b ? CommonResult.success(null) : CommonResult.failed();
    }

}
