package com.mall.doublerow.entity.dto;

import com.mall.doublerow.model.CmsSubject;
import com.mall.doublerow.model.PmsBrand;
import com.mall.doublerow.model.PmsProduct;
import com.mall.doublerow.model.SmsHomeAdvertise;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 首页内容返回信息封装
 * Created by macro on 2019/1/28.
 */
@Getter
@Setter
public class HomeContentResult {
    @ApiModelProperty("轮播广告")
    private List<SmsHomeAdvertise> advertiseList;
    @ApiModelProperty("新品推荐")
    private List<PmsProduct> newProductList;
}
