package com.mall.doublerow.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserMemberController
 * @Description TODO
 * @Date 2023/3/27 17:22
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserMemberController {

    @PostMapping("login")
    public String login() {
        StpUtil.login(1);
        return "hh";
    }

    @SaCheckLogin
    @PostMapping("loginout")
    public String loginout() {
        StpUtil.logout(1);
        return "ww";
    }

}
