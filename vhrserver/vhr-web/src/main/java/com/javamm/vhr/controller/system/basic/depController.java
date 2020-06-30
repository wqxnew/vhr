package com.javamm.vhr.controller.system.basic;

import com.javamm.vhr.model.Department;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/dept")
public class depController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public List<Department> getAllDeptById(){
        return departmentService.getAllDeptById();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        departmentService.addDep(dep);
        if(dep.getResult()==1){
            return RespBean.ok("添加成功！",dep);
        }else {
            return RespBean.ok("添加失败！");
        }
    }
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDep(dep);
        if(dep.getResult()==-2){
            return RespBean.error("该部门有子部门，无法删除！");
        }else if(dep.getResult()==-1){
            return RespBean.error("该部门有成员，无法删除！");
        }else if(dep.getResult()==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
