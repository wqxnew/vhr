package com.javamm.vhr.service;

import com.javamm.vhr.mapper.RoleMapper;
import com.javamm.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    public Integer addRole(Role role) {

        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insertSelective(role);
    }

    public Integer deleteRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
