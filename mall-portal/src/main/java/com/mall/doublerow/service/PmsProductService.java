package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.doublerow.entity.dto.PmsPortalProductDetailDto;
import com.mall.doublerow.entity.dto.PmsProductCategoryNodeDto;
import com.mall.doublerow.entity.vo.PmsProductVo;
import com.mall.doublerow.mapper.PmsProductMapper;
import com.mall.doublerow.model.PmsProduct;
import org.springframework.stereotype.Service;

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
    List<PmsProductCategoryNodeDto> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetailDto detail(Long id);
}
