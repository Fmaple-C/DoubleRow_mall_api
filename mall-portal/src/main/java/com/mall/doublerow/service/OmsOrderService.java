package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.api.CommonPage;
import com.mall.doublerow.entity.dto.OmsOrderDetail;
import com.mall.doublerow.model.OmsOrder;

import java.util.List;


/**
 * @ClassName OmsOrderService
 * @Date 2023/4/11 23:37
 * @Version 1.0
 */
public interface OmsOrderService extends IService<OmsOrder> {

    CommonPage<OmsOrderDetail> listAll(Long memberId, Integer pageNum, Integer pageSize);
}
