package com.mall.doublerow.controller;

import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.dto.HomeContentResultDto;
import com.mall.doublerow.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Date 2023/3/31 16:21
 * @Version 1.0
 */
@Api(tags = "HomeController")
@Tag(name = "HomeController",description = "HomeController")
@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation("首页内容信息展示")
    @GetMapping("content")
    public CommonResult<HomeContentResultDto> content() {
        HomeContentResultDto contentResult = homeService.content();
        return CommonResult.success(contentResult);
    }

}
