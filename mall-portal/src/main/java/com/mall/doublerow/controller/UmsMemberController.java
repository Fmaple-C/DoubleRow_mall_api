package com.mall.doublerow.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.vo.UmsMemberLoginVo;
import com.mall.doublerow.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName UserMemberController
 * @Description TODO
 * @Date 2023/3/27 17:22
 * @Version 1.0
 */
@Api(tags = "UmsMemberController")
@Tag(name = "UmsMemberController", description = "用户管理")
@RestController
@RequestMapping("userMember")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public CommonResult login(@Validated @RequestBody UmsMemberLoginVo umsMemberVo) {
        Map<String, Object> login = umsMemberService.login(umsMemberVo);
        if (login != null) {
            return CommonResult.success(login);
        }
        else
            return CommonResult.failed();
    }

    @PostMapping("loginout")
    public String loginout() {
        StpUtil.logout(1);
        return "ww";
    }

}
