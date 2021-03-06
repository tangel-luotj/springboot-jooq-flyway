package com.luotj.jooqtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.print.Pageable;

/**
 * @author create by luotj
 * @Date: 2020/5/22 3:17 下午
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Api")
                .apiInfo(
                        //配置在线文档的基本信息
                        new ApiInfoBuilder()
                                .title("接口文档")
                                .description("文档仅供学习使用")
                                .version("1.0")
                                .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luotj.jooqtest"))
                .paths(PathSelectors.any())
                .build();
    }


}
