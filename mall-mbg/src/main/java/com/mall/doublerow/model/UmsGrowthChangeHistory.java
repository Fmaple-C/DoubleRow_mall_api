package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 成长值变化历史记录表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class UmsGrowthChangeHistory implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long memberId;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      /**
     * 改变类型：0->增加；1->减少
     */
      private Integer changeType;

      /**
     * 积分改变数量
     */
      private Integer changeCount;

      /**
     * 操作人员
     */
      private String operateMan;

      /**
     * 操作备注
     */
      private String operateNote;

      /**
     * 积分来源：0->购物；1->管理员修改
     */
      private Integer sourceType;


}
