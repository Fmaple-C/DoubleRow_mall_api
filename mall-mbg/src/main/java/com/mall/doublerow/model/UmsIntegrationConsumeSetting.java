package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分消费设置
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class UmsIntegrationConsumeSetting implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 每一元需要抵扣的积分数量
     */
      private Integer deductionPerAmount;

      /**
     * 每笔订单最高抵用百分比
     */
      private Integer maxPercentPerOrder;

      /**
     * 每次使用积分最小单位100
     */
      private Integer useUnit;

      /**
     * 是否可以和优惠券同用；0->不可以；1->可以
     */
      private Integer couponStatus;


}
