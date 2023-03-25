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
 * 专题评论表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsSubjectComment implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long subjectId;

    private String memberNickName;

    private String memberIcon;

    private String content;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

    private Integer showStatus;


}
