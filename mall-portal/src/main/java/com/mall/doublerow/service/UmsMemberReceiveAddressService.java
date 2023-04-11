package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.model.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddress> {

    /**
     * 添加收货地址
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * 返回当前用户的收货地址
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * 获取地址详情
     * @param id 地址id
     */
    UmsMemberReceiveAddress getItem(Long id);
}
