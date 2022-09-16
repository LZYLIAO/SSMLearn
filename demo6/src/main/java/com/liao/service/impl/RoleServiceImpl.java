package com.liao.service.impl;

import com.liao.dao.RoleDao;
import com.liao.domain.Role;
import com.liao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }
}
