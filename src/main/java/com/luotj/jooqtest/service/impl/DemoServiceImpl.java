package com.luotj.jooqtest.service.impl;

import com.luotj.jooqtest.dao.RoleDao;
import com.luotj.jooqtest.dao.UserDao;
import com.luotj.jooqtest.exception.MyException;
import com.luotj.jooqtest.service.DemoService;
import com.luotj.jooqtest.ui.controller.request.CreateRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.request.ModifyRoleInfoRequest;
import com.luotj.jooqtest.ui.controller.response.RoleInfoResponse;
import generated_jooq.tables.pojos.Role;
import generated_jooq.tables.pojos.User;
import generated_jooq.tables.records.RoleRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author create by luotj
 * @Date: 2020/6/2 6:03 下午
 **/
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserDao mUserDao;
    @Autowired
    private RoleDao mRoleDao;

    @Override
    public String testDemo1(String name) {
        User user = Optional.ofNullable(mUserDao.judgeUserNameHasExistBy(name))
                .orElseThrow(() -> new MyException("用户不存在!"));

        return "hello , " + user.getName() + "!! welcome to jooq test !!";
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean testTransaction() {
        List<Long> listUserIds = new ArrayList<>();
        for (Long i = 0L; i < 100000; i++) {
            listUserIds.add(i);
        }
        List<List<Long>> subList = ListUtils.partition(listUserIds, 10000);
        Long begin = Instant.now().toEpochMilli();
        subList.forEach(it -> {
            mRoleDao.testTransaction(listUserIds);
        });
        Long end = Instant.now().toEpochMilli();
        log.info("begin:{}",begin);
        log.info("end:{}",end);
        log.info("总耗时:{}" , end - begin);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void DeleteAllRoleInfo() {
        mRoleDao.DeleteAllRoleInfo();
    }

    @Override
    public void createRoleInfo(CreateRoleInfoRequest request) {
        RoleRecord record = new RoleRecord()
                .setRoleName(request.getRoleName())
                .setCreateAt(Instant.now().getEpochSecond())
                .setUserId(request.getUserId());
        mRoleDao.createRoleInfo(record);
    }

    @Override
    public void modifyRoleInfoBy(ModifyRoleInfoRequest request) {
        mRoleDao.modifyRoleInfoBy(request);
    }

    @Override
    public List<RoleInfoResponse> queryAllRole() {
        return mRoleDao.queryAllRole();
    }

    @Override
    public Role queryRoleInfoBy(Long roleId) {
        return mRoleDao.queryRoleInfoBy(roleId).orElse(null);
    }

    @Override
    public void deleteRoleInfoBy(Long roleId) {
        mRoleDao.deleteRoleInfoBy(roleId);
    }

}