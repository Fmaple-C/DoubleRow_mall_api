package com.mall.doublerow.model;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-25
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsMemberReport implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

      /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
      private Integer reportType;

      /**
     * 举报人
     */
      private String reportMemberName;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

    private String reportObject;

      /**
     * 举报状态：0->未处理；1->已处理
     */
      private Integer reportStatus;

      /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
      private Integer handleStatus;

    private String note;


}
