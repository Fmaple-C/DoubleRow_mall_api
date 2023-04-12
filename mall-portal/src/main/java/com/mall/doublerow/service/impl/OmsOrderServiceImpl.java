package com.mall.doublerow.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.mall.doublerow.api.CommonPage;
import com.mall.doublerow.entity.dto.OmsOrderDetail;
import com.mall.doublerow.mapper.OmsOrderItemMapper;
import com.mall.doublerow.mapper.OmsOrderMapper;
import com.mall.doublerow.model.OmsOrder;
import com.mall.doublerow.model.OmsOrderItem;
import com.mall.doublerow.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OmsOrderServiceImpl
 * @Date 2023/4/11 23:38
 * @Version 1.0
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements OmsOrderService {

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Override
    public CommonPage<OmsOrderDetail> listAll(Long memberId,Integer status, Integer pageNum, Integer pageSize) {
        if(status==-1){
            status = null;
        }
        PageHelper.startPage(pageNum,pageSize);
        QueryWrapper<OmsOrder> orderwrapper = new QueryWrapper<>();
        orderwrapper.eq("delete_status",0)
                .eq("member_id",memberId)
                .orderByDesc("create_time");
        List<OmsOrder> omsOrders = omsOrderMapper.selectList(orderwrapper);
        CommonPage<OmsOrder> orderPage = CommonPage.restPage(omsOrders);
        //设置分页信息
        CommonPage<OmsOrderDetail> resultPage = new CommonPage<>();
        resultPage.setPageNum(orderPage.getPageNum());
        resultPage.setPageSize(orderPage.getPageSize());
        resultPage.setTotal(orderPage.getTotal());
        resultPage.setTotalPage(orderPage.getTotalPage());
        if (CollUtil.isNotEmpty(omsOrders))
            return resultPage;
        List<Long> orderIdds = omsOrders.stream().map(OmsOrder::getId).collect(Collectors.toList());
        QueryWrapper<OmsOrderItem> itemwrapper = new QueryWrapper<>();
        itemwrapper.in("order_id",orderIdds);
        List<OmsOrderItem> omsOrderItems = omsOrderItemMapper.selectList(itemwrapper);
        List<OmsOrderDetail> orderDetailList = new ArrayList<>();
        for (OmsOrder omsOrder : omsOrders) {
            OmsOrderDetail orderDetail = new OmsOrderDetail();
            BeanUtil.copyProperties(omsOrder,orderDetail);
            List<OmsOrderItem> relatedItemList = omsOrderItems.stream().filter(item -> item.getOrderId().equals(orderDetail.getId())).collect(Collectors.toList());
            orderDetail.setOrderItemList(relatedItemList);
            orderDetailList.add(orderDetail);
        }
        resultPage.setList(orderDetailList);
        return resultPage;
    }
}
