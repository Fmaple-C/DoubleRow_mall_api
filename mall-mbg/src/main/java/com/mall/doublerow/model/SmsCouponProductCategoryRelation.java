package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优惠券和产品分类关系表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SmsCouponProductCategoryRelation implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long couponId;

    private Long productCategoryId;

      /**
     * 产品分类名称
     */
      private String productCategoryName;

      /**
     * 父分类名称
     */
      private String parentCategoryName;


}
