package com.javamm.vhr.service;

import com.javamm.vhr.mapper.MenuMapper;
import com.javamm.vhr.mapper.MenuRoleMapper;
import com.javamm.vhr.model.Hr;
import com.javamm.vhr.model.Menu;
import com.javamm.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.SecurityConstants;

import java.security.Security;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public List<Menu> getMenuByHrId(){
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }

    public List<Integer> getRole_Menus(Integer rid) {
        return menuMapper.getRole_Menus(rid);
    }
    @Transactional
    public boolean updateMenuRoles(Integer rid,Integer[] mids) {
        if(mids==null || mids.length==0){
            return true;
        }
        menuRoleMapper.deleteByRid(rid);
        Integer result=menuRoleMapper.updateMenuRoles(rid,mids);
        return result==mids.length;
    }
}
