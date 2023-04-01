package com.mall.doublerow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.mall.doublerow.dao.HomeDao;
import com.mall.doublerow.entity.dto.HomeContentResultDto;
import com.mall.doublerow.mapper.PmsProductMapper;
import com.mall.doublerow.mapper.SmsHomeAdvertiseMapper;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.model.SmsHomeAdvertise;
import com.mall.doublerow.service.HomeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HomeServiceImpl
 * @Description TODO
 * @Date 2023/4/1 13:09
 * @Version 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private SmsHomeAdvertiseMapper smsHomeAdvertiseMapper;

    @Autowired
    private HomeDao homeDao;

    @Override
    public HomeContentResultDto content() {
        HomeContentResultDto result = new HomeContentResultDto();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取新品推荐
        result.setNewProductList(homeDao.getNewProductList(0,4));
        return result;
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status", 0)
                .eq("publish_status", 0);
        return pmsProductMapper.selectList(wrapper);
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        QueryWrapper<SmsHomeAdvertise> wrapper = new QueryWrapper<>();
        wrapper.eq("type", 1)
                .eq("status", 1)
                .orderByDesc("sort");
        return smsHomeAdvertiseMapper.selectList(wrapper);
    }
}
