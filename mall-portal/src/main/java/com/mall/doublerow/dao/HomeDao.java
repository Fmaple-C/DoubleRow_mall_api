package com.mall.doublerow.dao;

import com.mall.doublerow.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeDao {

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
