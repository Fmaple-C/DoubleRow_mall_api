package com.mall.doublerow.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品阶梯价格表(只针对同商品)
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class PmsProductLadder implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long productId;

      /**
     * 满足的商品数量
     */
      private Integer count;

      /**
     * 折扣
     */
      private BigDecimal discount;

      /**
     * 折后价格
     */
      private BigDecimal price;


}
