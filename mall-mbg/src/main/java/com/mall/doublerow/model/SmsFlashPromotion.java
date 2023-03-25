package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 限时购表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SmsFlashPromotion implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String title;

      /**
     * 开始日期
     */
      private LocalDate startDate;

      /**
     * 结束日期
     */
      private LocalDate endDate;

      /**
     * 上下线状态
     */
      private Integer status;

      /**
     * 秒杀时间段名称
     */
        @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;


}
