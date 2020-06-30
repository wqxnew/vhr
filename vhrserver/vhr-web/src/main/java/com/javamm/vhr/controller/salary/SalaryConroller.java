package com.javamm.vhr.controller.salary;

import com.javamm.vhr.SalaryService;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryConroller {
    @Autowired
    SalaryService salaryService;
    @GetMapping("/")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PostMapping("/")
    public RespBean addSalaries(@RequestBody Salary salary){
        if(salaryService.addSalaries(salary)==1){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalary(@PathVariable Integer id){
        if(salaryService.deleteSalary(id)==1){
            return  RespBean.ok("删除成功！");
        }else{
            return  RespBean.ok("删除失败！");
        }
    }

    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary){
        if(salaryService.updateSalary(salary)==1){
            return RespBean.ok("更新成功！");
        }else{
            return RespBean.error("更新失败！");
        }
    }
}
