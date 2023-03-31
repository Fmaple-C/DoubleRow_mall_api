package com.mall.doublerow.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
