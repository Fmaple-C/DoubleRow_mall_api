package com.mall.doublerow;

import com.mall.doublerow.mapper.UmsMemberLevelMapper;
import com.mall.doublerow.model.UmsMemberLevel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallPortalApplicationTests {

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    @Test
    void testone() {
        System.out.println(umsMemberLevelMapper);
        List<UmsMemberLevel> umsMemberLevels = umsMemberLevelMapper.selectList(null);
        System.out.println(umsMemberLevels);

    }

}
