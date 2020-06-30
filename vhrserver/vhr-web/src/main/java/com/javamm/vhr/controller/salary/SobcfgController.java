package com.javamm.vhr.controller.salary;

import com.javamm.vhr.SalaryService;
import com.javamm.vhr.model.Employee;
import com.javamm.vhr.model.ResPageBean;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.model.Salary;
import com.javamm.vhr.service.SobcfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobcfgController {

    @Autowired
    SobcfgService sobcfgService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public ResPageBean getAllEmpWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        return sobcfgService.getAllEmpWithSalary(page,size);
    }
    @GetMapping("/salary")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }
    @PutMapping("/")
    public RespBean updateByEidAndSid(Integer eid,Integer sid){
        Integer res=sobcfgService.updateByEidAndSid(eid,sid);
        if(res==1||res==2){
            return RespBean.ok("修改成功！");
        }else{
            return RespBean.error("修改失败！");
        }
    }
}
