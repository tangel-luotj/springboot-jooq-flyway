package com.luotj.jooqtest.service;

import com.luotj.jooqtest.ui.controller.request.CreateRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.request.ModifyRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.response.RoleInfoResponse;
import generated_jooq.tables.pojos.Role;
import generated_jooq.tables.records.RoleRecord;

import java.util.List;
import java.util.Optional;

/**
 * @author create by luotj
 * @Date: 2020/6/2 6:03 下午
 **/
public interface DemoService {

    String testDemo1(String name);

    Boolean testTransaction();

    void DeleteAllRoleInfo();

    void createRoleInfo(CreateRoleInfoRequest request);

    void modifyRoleInfoBy(ModifyRoleInfoRequest request);

    List<RoleInfoResponse> queryAllRole();

    Role queryRoleInfoBy(Long roleId);

    void deleteRoleInfoBy(Long roleId);
}
