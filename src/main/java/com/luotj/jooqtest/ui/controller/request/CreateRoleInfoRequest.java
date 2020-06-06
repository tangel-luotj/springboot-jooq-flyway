package com.luotj.jooqtest.ui.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author create by luotj
 * @Date: 2020/6/6 11:15 上午
 **/
@ApiModel
@Data
public class CreateRoleInfoRequest {

    @ApiModelProperty(value = "用户ID", required = true , position = 1, example = "1")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @ApiModelProperty(value = "角色名称", required = true , position = 2, example = "丑角")
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

}
