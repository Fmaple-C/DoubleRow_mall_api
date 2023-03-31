package com.mall.doublerow;

import com.mall.doublerow.entity.vo.UmsMemberVo;
import com.mall.doublerow.service.UmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class MallPortalApplicationTests {

    @Autowired
    private UmsMemberService umsMemberService;

    @Test
    void testone() {
        UmsMemberVo admin = new UmsMemberVo("admin", "123456");
        Map<String, Object>maps = umsMemberService.login(admin);
    }

}
