package com.luotj.jooqtest.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author create by luotj
 * @Date: 2020/6/4 3:15 下午
 **/
public abstract class BaseDao {

    @Qualifier("dsl")
    @Autowired
    protected DSLContext mDSLContext;

    public BaseDao(){
    }

}
