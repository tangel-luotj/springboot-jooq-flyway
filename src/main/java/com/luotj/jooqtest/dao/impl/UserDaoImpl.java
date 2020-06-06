package com.luotj.jooqtest.dao.impl;

import com.luotj.jooqtest.dao.BaseDao;
import com.luotj.jooqtest.dao.UserDao;
import generated_jooq.tables.pojos.User;
import generated_jooq.tables.records.RoleRecord;
import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static generated_jooq.tables.User.USER;
import static generated_jooq.tables.Role.ROLE;

/**
 * @author create by luotj
 * @Date: 2020/6/2 6:06 下午
 **/
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User judgeUserNameHasExistBy(String name) {
        return mDSLContext.selectFrom(USER)
                .where(USER.NAME.eq(name))
                .fetchOneInto(User.class);
    }
}
