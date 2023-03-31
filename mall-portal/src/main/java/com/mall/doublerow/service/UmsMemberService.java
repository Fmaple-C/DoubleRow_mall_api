package com.mall.doublerow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.entity.vo.UmsMemberLoginVo;
import com.mall.doublerow.model.UmsMember;

import java.util.Map;

public interface UmsMemberService extends IService<UmsMember> {

    Map<String, Object> login(UmsMemberLoginVo umsMemberVo);
}
