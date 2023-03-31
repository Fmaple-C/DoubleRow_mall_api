package com.mall.doublerow.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.mall.doublerow.api.CommonResult;
import com.mall.doublerow.entity.vo.UmsMemberURVo;
import com.mall.doublerow.entity.vo.UmsMemberVo;
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
    public CommonResult login(@Validated @RequestBody UmsMemberVo umsMemberVo) {
        Map<String, Object> login = umsMemberService.login(umsMemberVo);
        if (login != null) {
            return CommonResult.success(login);
        }
        else
            return CommonResult.failed();
    }

    @ApiOperation("用户登录")
    @PostMapping("register")
    public CommonResult register(@Validated @RequestBody UmsMemberVo umsMemberVo) {
        int regitster = umsMemberService.register(umsMemberVo);
        if (regitster == 0)
            return CommonResult.failed("用户名重复，请重新输入");
        else
            return CommonResult.success(null,"注册成功");
    }

    @PostMapping("loginout")
    public String loginout() {
        StpUtil.logout(1);
        return "ww";
    }

}
