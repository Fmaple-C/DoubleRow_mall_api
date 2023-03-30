package com.mall.doublerow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.doublerow.entity.vo.UmsMemberVo;
import com.mall.doublerow.mapper.UmsMemberMapper;
import com.mall.doublerow.model.UmsMember;
import com.mall.doublerow.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UmsMemberServiceImpl
 * @Description TODO
 * @Date 2023/3/29 20:29
 * @Version 1.0
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService{

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public UmsMember login(UmsMemberVo umsMemberVo) {
        QueryWrapper<UmsMember> wrapper = new QueryWrapper<>();
        wrapper.eq("username",umsMemberVo.getUsername())
                .eq("password",umsMemberVo.getPassword());
        UmsMember ums = umsMemberMapper.selectOne(wrapper);
        if (ums != null) {
            return ums;
        }
        return null;
    }
}
