package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.model.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OmsCartItemService extends IService<OmsCartItem> {

    List<OmsCartItem> list(Long memberId);

    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     */
    @Transactional
    int add(OmsCartItem cartItem);
}
