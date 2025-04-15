package org.hae.yl.service.Impl;

import org.hae.yl.entity.Role;
import org.hae.yl.mapper.RoleMapper;
import org.hae.yl.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper rolemapper;


    @Override
    public List<Role> SelectAll() {
        return rolemapper.SelectAll();
    }

    @Override
    public Role SelectById(int id) {
        return rolemapper.SelectById(id);
    }
}
