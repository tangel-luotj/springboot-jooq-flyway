package com.luotj.jooqtest.dao;

import generated_jooq.tables.pojos.User;

import java.util.List;

/**
 * @author create by luotj
 * @Date: 2020/6/2 6:06 下午
 **/
public interface UserDao {

    User judgeUserNameHasExistBy(String name);

}
