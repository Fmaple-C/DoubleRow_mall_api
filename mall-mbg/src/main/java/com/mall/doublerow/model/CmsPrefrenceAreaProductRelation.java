package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优选专区和产品关系表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CmsPrefrenceAreaProductRelation implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long prefrenceAreaId;

    private Long productId;


}
