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
 * 产品评价回复表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class PmsCommentReplay implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long commentId;

    private String memberNickName;

    private String memberIcon;

    private String content;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      /**
     * 评论人员类型；0->会员；1->管理员
     */
      private Integer type;


}
