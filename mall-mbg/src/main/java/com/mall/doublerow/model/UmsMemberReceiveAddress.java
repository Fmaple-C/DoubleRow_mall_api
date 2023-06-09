package com.mall.doublerow.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员收货地址表
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class UmsMemberReceiveAddress implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long memberId;

      /**
     * 收货人名称
     */
      private String name;

    private String phoneNumber;

      /**
     * 是否为默认
     */
      private Integer defaultStatus;

      /**
     * 邮政编码
     */
      private String postCode;

      /**
     * 省份/直辖市
     */
      private String province;

      /**
     * 城市
     */
      private String city;

      /**
     * 区
     */
      private String region;

      /**
     * 详细地址(街道)
     */
      private String detailAddress;


}
