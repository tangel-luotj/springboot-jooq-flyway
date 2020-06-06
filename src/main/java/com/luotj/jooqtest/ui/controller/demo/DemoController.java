package com.luotj.jooqtest.ui.controller.demo;

import com.luotj.jooqtest.service.DemoService;
import com.luotj.jooqtest.ui.controller.request.CreateRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.request.ModifyRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.response.RoleInfoResponse;
import generated_jooq.tables.pojos.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author create by luotj
 * @Date: 2020/5/22 2:46 下午
 **/
@Api(tags = "01. 基础测试")
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private DemoService mDemoService;

    @ApiOperation("测试(测试swagger)")
    @GetMapping("/demo1/{name}")
    @ResponseBody
    public String testDemo1(@PathVariable @ApiParam(value = "你的姓名(Your name)", required = true, example = "张三") String name) {
        //判断数据库中是否有该名字，
        return mDemoService.testDemo1(name);
    }

//    @ApiOperation("事务管理")
//    @PostMapping("/create")
//    public Boolean testTransaction(){
//        return mDemoService.testTransaction();
//    }

    @ApiOperation("删除角色表所有数据")
    @DeleteMapping("/delete")
    public void DeleteAllRoleInfo() {
        mDemoService.DeleteAllRoleInfo();
    }

    @ApiOperation("新增角色")
    @PostMapping("/insert")
    public void createRoleInfo(@RequestBody @Valid CreateRoleInfoRequest request) {
        mDemoService.createRoleInfo(request);
    }

    @ApiOperation("修改角色信息")
    @PutMapping("/update")
    public void modifyRoleInfoBy(@RequestBody @Valid ModifyRoleInfoRequest request) {
        mDemoService.modifyRoleInfoBy(request);
    }

    @ApiOperation("获取所有角色信息")
    @GetMapping("/all-role")
    public List<RoleInfoResponse> queryAllRole() {
        return mDemoService.queryAllRole();
    }

    @ApiOperation("获取用户详情")
    @GetMapping("/role-info")
    public Role queryRoleInfoBy(Long roleId) {
        return mDemoService.queryRoleInfoBy(roleId);
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete-role")
    public void deleteRoleInfoBy(Long roleId) {
        mDemoService.deleteRoleInfoBy(roleId);
    }
}
