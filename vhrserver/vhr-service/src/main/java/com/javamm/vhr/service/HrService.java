package com.javamm.vhr.service;

import com.javamm.vhr.mapper.HrMapper;
import com.javamm.vhr.mapper.HrRoleMapper;
import com.javamm.vhr.model.Hr;
import com.javamm.vhr.util.HrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if(hr == null){
            throw  new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHr(String keywords) {
        return hrMapper.getAllHr(keywords,HrUtil.getLocalUser().getId());
    }

    public Integer updateUser(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Boolean updateRole(Integer hrid, Integer[] rid) {
        hrRoleMapper.deleteByHrid(hrid);
       return hrRoleMapper.addRole(hrid,rid);
    }

    public List<Hr> getAllHrWithoutHrSelf() {
        return hrMapper.getAllHrWithoutHrSelf(HrUtil.getLocalUser().getId());
    }
}
