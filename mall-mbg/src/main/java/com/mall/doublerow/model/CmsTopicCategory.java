package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 话题分类表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsTopicCategory implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

      /**
     * 分类图标
     */
      private String icon;

      /**
     * 专题数量
     */
      private Integer subjectCount;

    private Integer showStatus;

    private Integer sort;


}
