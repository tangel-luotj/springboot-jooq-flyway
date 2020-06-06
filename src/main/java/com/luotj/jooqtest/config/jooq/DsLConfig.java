package com.luotj.jooqtest.config.jooq;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置DSLContent
 * @author create by luotj
 * @Date: 2020/6/2 6:26 下午
 **/
@Configuration
public class DsLConfig {

    @Autowired
    private DataSource mDataSource;
    @Bean
    public DSLContext dsl() {
        return DSL.using(mDataSource, SQLDialect.MYSQL);
    }

}
