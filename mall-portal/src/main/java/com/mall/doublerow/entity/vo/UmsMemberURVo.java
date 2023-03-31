package com.mall.doublerow.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName UmsMemverRegister
 * @Description TODO
 * @Date 2023/3/31 13:29
 * @Version 1.0
 */
@Data
public class UmsMemberURVo {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("头像")
    private String icon;

    @ApiModelProperty("性别")
    private Long gender;

    @ApiModelProperty("生日")
    private LocalDate birthday;

    @ApiModelProperty("所做城市")
    private String city;

    @ApiModelProperty("职业")
    private String job;

    @ApiModelProperty("个性签名")
    private String personalizedSignature;

}
