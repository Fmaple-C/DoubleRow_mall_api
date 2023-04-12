package com.mall.doublerow.entity.dto;

import com.mall.doublerow.model.OmsOrder;
import com.mall.doublerow.model.OmsOrderItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含商品信息的订单详情
 * Created by macro on 2018/9/4.
 */
@Getter
@Setter
public class OmsOrderDetail extends OmsOrder {
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
}
