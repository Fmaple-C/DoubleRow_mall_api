package com.mall.doublerow.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.doublerow.mapper.UmsMemberReceiveAddressMapper;
import com.mall.doublerow.model.UmsMemberReceiveAddress;
import com.mall.doublerow.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UmsMemberReceiveAddressServiceImpl
 * @Description TODO
 * @Date 2023/4/11 9:31
 * @Version 1.0
 */
@Service
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressMapper, UmsMemberReceiveAddress> implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public int add(UmsMemberReceiveAddress address) {
        address.setMemberId(Long.valueOf(String.valueOf(StpUtil.getExtra("memberId"))));
        return umsMemberReceiveAddressMapper.insert(address);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        QueryWrapper<UmsMemberReceiveAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", StpUtil.getExtra("memberId"));
        return umsMemberReceiveAddressMapper.selectList(wrapper);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        QueryWrapper<UmsMemberReceiveAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", StpUtil.getExtra("memberId"))
                .eq("id",id);
        return umsMemberReceiveAddressMapper.selectOne(wrapper);
    }

}
