package com.mall.doublerow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductVo productQueryParam, Integer pageSize, Integer pageNum);

}
