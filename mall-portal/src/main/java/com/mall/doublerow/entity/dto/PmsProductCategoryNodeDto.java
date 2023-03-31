package com.mall.doublerow.entity.dto;

import com.mall.doublerow.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含子分类的商品分类
 * Created by macro on 2020/4/6.
 */
@Getter
@Setter
public class PmsProductCategoryNodeDto extends PmsProductCategory {
    @ApiModelProperty("子分类集合")
    private List<PmsProductCategoryNodeDto> children;
}
