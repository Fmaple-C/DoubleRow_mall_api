package com.mall.doublerow.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName UmsMemberVo
 * @Description TODO
 * @Date 2023/3/29 20:31
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsMemberVo {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
