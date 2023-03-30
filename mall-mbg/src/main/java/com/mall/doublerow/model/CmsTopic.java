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
 * 话题表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsTopic implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long categoryId;

    private String name;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

      /**
     * 参与人数
     */
      private Integer attendCount;

      /**
     * 关注人数
     */
      private Integer attentionCount;

    private Integer readCount;

      /**
     * 奖品名称
     */
      private String awardName;

      /**
     * 参与方式
     */
      private String attendType;

      /**
     * 话题内容
     */
      private String content;


}
