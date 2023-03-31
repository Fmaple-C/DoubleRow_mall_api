package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonPage;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.vo.PmsProductVo;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PmsProductController
 * @Description TODO
 * @Date 2023/3/31 9:38
 * @Version 1.0
 */
@Api(tags = "PmsProductController")
@Tag(name = "PmsProductController", description = "商品管理")
@RestController
@RequestMapping("psmProduct")
public class PmsProductController {

    @Autowired
    private PmsProductService productService;

    @ApiOperation("查询商品")
    @GetMapping("list")
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductVo pmsProductvo,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(pmsProductvo, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }
}
