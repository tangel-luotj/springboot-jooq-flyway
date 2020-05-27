package com.luotj.jooqtest.ui.controller.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author create by luotj
 * @Date: 2020/5/22 2:46 下午
 **/
@Api(tags = "01. 基础测试")
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @ApiOperation("测试(测试swagger)")
    @GetMapping("/demo1/{name}")
    @ResponseBody
    public String testDemo1(@PathVariable @ApiParam(value = "你的姓名(Your name)", required = true, example = "张三") String name) {
        return "hello , " + name + "!! welcome to jooq test !!";
    }

}
