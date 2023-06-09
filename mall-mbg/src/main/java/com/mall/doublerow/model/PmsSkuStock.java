package com.mall.doublerow.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku的库存
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class PmsSkuStock implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long productId;

      /**
     * sku编码
     */
      private String skuCode;

    private BigDecimal price;

      /**
     * 库存
     */
      private Integer stock;

      /**
     * 预警库存
     */
      private Integer lowStock;

      /**
     * 展示图片
     */
      private String pic;

      /**
     * 销量
     */
      private Integer sale;

      /**
     * 单品促销价格
     */
      private BigDecimal promotionPrice;

      /**
     * 锁定库存
     */
      private Integer lockStock;

      /**
     * 商品销售属性，json格式
     */
      private String spData;


}
