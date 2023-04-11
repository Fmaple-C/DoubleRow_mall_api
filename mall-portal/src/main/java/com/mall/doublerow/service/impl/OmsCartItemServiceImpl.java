package com.mall.doublerow.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.doublerow.mapper.OmsCartItemMapper;
import com.mall.doublerow.model.OmsCartItem;
import com.mall.doublerow.service.OmsCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName OmsCartItemServiceImpl
 * @Date 2023/4/8 22:49
 * @Version 1.0
 */
@Service
public class OmsCartItemServiceImpl  extends ServiceImpl<OmsCartItemMapper, OmsCartItem> implements OmsCartItemService {

    @Autowired
    private OmsCartItemMapper omsCartItemMapper;

    @Override
    public List<OmsCartItem> list(Long memberId) {
        QueryWrapper<OmsCartItem> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0)
                .eq("member_id",memberId);
        return omsCartItemMapper.selectList(wrapper);
    }

    @Override
    public int add(OmsCartItem cartItem) {
        int count = 0;
        cartItem.setMemberId(Long.valueOf(String.valueOf(StpUtil.getExtra("memberId"))));
        cartItem.setMemberNickname(String.valueOf(StpUtil.getExtra("nickname")));
        cartItem.setDeleteStatus(0);
        OmsCartItem existCartItem = getCartItem(cartItem);
        if (existCartItem == null) {
            cartItem.setCreateDate(LocalDateTime.now());
            count = omsCartItemMapper.insert(cartItem);
        }
        else {
            cartItem.setModifyDate(LocalDateTime.now());
            existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
            count = omsCartItemMapper.updateById(existCartItem);
        }
        return count;
    }

    /**
     * 根据会员id,商品id和规格获取购物车中商品
     * @return
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {
        QueryWrapper<OmsCartItem> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id",cartItem.getMemberId())
                .eq("product_id",cartItem.getProductId())
                .eq("delete_status",1);
        if (cartItem.getProductSkuId() != null)
            wrapper.eq("product_sku_id",cartItem.getProductSkuId());
        List<OmsCartItem> omsCartItems = omsCartItemMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(omsCartItems))
            return omsCartItems.get(0);
        return null;
    }
}
