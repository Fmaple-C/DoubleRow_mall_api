package com.mall.doublerow.entity.dto;

import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.model.PmsProductAttribute;
import com.mall.doublerow.model.PmsProductAttributeValue;
import com.mall.doublerow.model.PmsSkuStock;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName PmsPortalProductDetailDto
 * @Description TODO
 * @Date 2023/4/4 9:10
 * @Version 1.0
 */
@Getter
@Setter
public class PmsPortalProductDetail {
    @ApiModelProperty("商品信息")
    private PmsProduct product;
    @ApiModelProperty("商品属性与参数")
    private List<PmsProductAttribute> productAttributeList;
    @ApiModelProperty("手动录入的商品属性与参数值")
    private List<PmsProductAttributeValue> productAttributeValueList;

}
