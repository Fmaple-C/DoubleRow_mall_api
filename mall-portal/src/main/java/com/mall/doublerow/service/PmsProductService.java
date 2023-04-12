package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.doublerow.entity.dto.PmsPortalProductDetail;
import com.mall.doublerow.entity.dto.PmsProductCategoryNode;
import com.mall.doublerow.model.PmsProduct;

import java.util.List;

/**
 * @ClassName PmsProductService
 * @Description TODO
 * @Date 2023/3/29 20:24
 * @Version 1.0
 */

public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 综合搜索商品
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}
