package com.mall.doublerow.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.entity.vo.UmsMemberVo;
import com.mall.doublerow.model.UmsMember;

public interface UmsMemberService extends IService<UmsMember> {

    UmsMember login(UmsMemberVo umsMemberVo);
}
