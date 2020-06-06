package com.luotj.jooqtest.dao;

import com.luotj.jooqtest.ui.controller.request.ModifyRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.response.RoleInfoResponse;
import generated_jooq.tables.pojos.Role;
import generated_jooq.tables.records.RoleRecord;

import java.util.List;
import java.util.Optional;

/**
 * @author create by luotj
 * @Date: 2020/6/5 6:10 下午
 **/
public interface RoleDao {

    int testTransaction(List<Long> listUserIds);

    void DeleteAllRoleInfo();

    void createRoleInfo(RoleRecord record);

    void modifyRoleInfoBy(ModifyRoleInfoRequest request);

    List<RoleInfoResponse> queryAllRole();

    Optional<Role> queryRoleInfoBy(Long roleId);

    void deleteRoleInfoBy(Long roleId);
}
