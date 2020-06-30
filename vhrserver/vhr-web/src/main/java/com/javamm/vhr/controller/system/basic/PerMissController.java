package com.javamm.vhr.controller.system.basic;

import com.javamm.vhr.model.Menu;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.model.Role;
import com.javamm.vhr.service.MenuService;
import com.javamm.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PerMissController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }
    @GetMapping("/mids/{rid}")
    public List<Integer> getRole_Menus(@PathVariable Integer rid){
       return menuService.getRole_Menus(rid);
    }
    @PutMapping("/")
    public RespBean updateMenuRoles(Integer rid,Integer[] mids){
        if(menuService.updateMenuRoles(rid,mids)){
            return RespBean.ok("修改成功！");
        }else{
            return RespBean.error("修改失败！");
        }
    }
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)==1){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.ok("添加成功！");
        }
    }
@DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if(roleService.deleteRole(rid)==1){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
}
