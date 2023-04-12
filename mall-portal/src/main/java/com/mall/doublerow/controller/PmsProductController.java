package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonPage;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.dto.PmsPortalProductDetail;
import com.mall.doublerow.entity.dto.PmsProductCategoryNode;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @GetMapping("search")
    public CommonResult<CommonPage<PmsProduct>> search(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false) Long brandId,
                               @RequestParam(required = false) Long productCategoryId,
                               @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                               @RequestParam(required = false, defaultValue = "0") Integer sort) {
        List<PmsProduct> productList = productService.search(keyword, brandId, productCategoryId, pageNum, pageSize, sort);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("以树形结构获取所有商品分类")
    @GetMapping("categoryTreeList")
    public CommonResult<List<PmsProductCategoryNode>> categoryTreeList() {
        List<PmsProductCategoryNode> list = productService.categoryTreeList();
        return CommonResult.success(list);
    }

    @ApiOperation("获取前台商品详情")
    @GetMapping("/detail/{id}")
    public CommonResult<PmsPortalProductDetail> detail(@PathVariable Long id) {
        PmsPortalProductDetail productDetail = productService.detail(id);
        return CommonResult.success(productDetail);
    }
}
