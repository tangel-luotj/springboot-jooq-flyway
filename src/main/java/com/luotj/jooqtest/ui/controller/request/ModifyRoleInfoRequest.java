package com.luotj.jooqtest.ui.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author create by luotj
 * @Date: 2020/6/6 11:04 上午
 **/
@ApiModel
@Data
public class ModifyRoleInfoRequest {

    @ApiModelProperty(value = "角色ID", required = true , position = 1, example = "1")
    private Long roleId;

    @ApiModelProperty(value = "角色名称", required = true , position = 2, example = "丑角")
    private String roleName;

}
