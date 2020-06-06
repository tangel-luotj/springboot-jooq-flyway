package com.luotj.jooqtest.ui.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author create by luotj
 * @Date: 2020/6/6 11:05 上午
 **/
@ApiModel
@Data
public class RoleInfoResponse {

    @ApiModelProperty(value = "唯一ID", example = "1", position = 1)
    private Long id;

    @ApiModelProperty(value = "用户ID", example = "1", position = 2)
    private Long userId;

    @ApiModelProperty(value = "角色名称", example = "丑角", position = 3)
    private String roleName;
}
