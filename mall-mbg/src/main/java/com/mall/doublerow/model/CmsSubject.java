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
 * 专题表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsSubject implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long categoryId;

    private String title;

      /**
     * 专题主图
     */
      private String pic;

      /**
     * 关联产品数量
     */
      private Integer productCount;

    private Integer recommendStatus;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

    private Integer collectCount;

    private Integer readCount;

    private Integer commentCount;

      /**
     * 画册图片用逗号分割
     */
      private String albumPics;

    private String description;

      /**
     * 显示状态：0->不显示；1->显示
     */
      private Integer showStatus;

    private String content;

      /**
     * 转发数
     */
      private Integer forwardCount;

      /**
     * 专题分类名称
     */
      private String categoryName;


}
