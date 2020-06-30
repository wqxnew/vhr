package com.javamm.vhr.controller.system;

import com.javamm.vhr.model.Hr;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.model.Role;
import com.javamm.vhr.service.HrService;
import com.javamm.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrConroller {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHr(String keywords){
        return hrService.getAllHr(keywords);
    }

    @PutMapping("/")
    public RespBean UpdateUser(@RequestBody Hr hr){
        if(hrService.updateUser(hr)==1){
            return RespBean.ok("更新成功！");
        }else{
            return RespBean.error("更新成功！");
        }
    }
    @GetMapping("/roles/")
    public List<Role> getAllRoles(){
        return roleService.getAllRole();
    }

    @PutMapping("/role")
    public RespBean updateRole(Integer hrid,Integer[] rids){
        if(hrService.updateRole(hrid,rids)){
            return RespBean.ok("更新成功！");
        }else{
            return RespBean.error("更新成功！");
        }
    }
}
