package com.mall.doublerow.service;

import com.mall.doublerow.entity.dto.HomeContentResultDto;
import com.mall.doublerow.model.PmsProduct;

import java.util.List;

/**
 * @ClassName HomeService
 * @Description TODO
 * @Date 2023/4/1 13:09
 * @Version 1.0
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResultDto content();

    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);


}
