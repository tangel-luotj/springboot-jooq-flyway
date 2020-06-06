package com.luotj.jooqtest.dao.impl;

import com.luotj.jooqtest.dao.BaseDao;
import com.luotj.jooqtest.dao.RoleDao;
import com.luotj.jooqtest.ui.controller.request.ModifyRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.response.RoleInfoResponse;
import generated_jooq.tables.pojos.Role;
import generated_jooq.tables.records.RoleRecord;
import org.jooq.InsertQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static generated_jooq.tables.Role.ROLE;

/**
 * @author create by luotj
 * @Date: 2020/6/5 6:11 下午
 **/
@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

    @Override
    public int testTransaction(List<Long> listUserIds) {
        InsertQuery<RoleRecord> query = mDSLContext.insertQuery(ROLE);
        listUserIds.forEach(it -> {
            RoleRecord roleRecord = new RoleRecord()
                    .setRoleName("测试")
                    .setUserId(it);
            query.addRecord(roleRecord);
        });
        return query.execute();
    }

    @Override
    public void DeleteAllRoleInfo() {
        mDSLContext.deleteFrom(ROLE)
                .execute();
    }

    @Override
    public void createRoleInfo(RoleRecord record) {
        InsertQuery<RoleRecord> insertQuery = mDSLContext.insertQuery(ROLE);
        insertQuery.addRecord(record);
        insertQuery.execute();
    }

    @Override
    public void modifyRoleInfoBy(ModifyRoleInfoRequest request) {
        mDSLContext.update(ROLE)
                .set(ROLE.ROLE_NAME, request.getRoleName())
                .where(ROLE.ID.eq(request.getRoleId()))
                .execute();
    }

    @Override
    public List<RoleInfoResponse> queryAllRole() {
        return mDSLContext.selectFrom(ROLE)
                .fetchInto(RoleInfoResponse.class);
    }

    @Override
    public Optional<Role> queryRoleInfoBy(Long roleId) {
        return mDSLContext.selectFrom(ROLE)
                .where(ROLE.ID.eq(roleId))
                .fetchOptionalInto(Role.class);
    }

    @Override
    public void deleteRoleInfoBy(Long roleId) {
        mDSLContext.delete(ROLE)
                .where(ROLE.ID.eq(roleId))
                .execute();
    }

}
