package com.javamm.vhr.controller.emp;

import com.javamm.vhr.model.*;
import com.javamm.vhr.service.*;
import com.javamm.vhr.util.EmpExport;
import com.javamm.vhr.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicContoller {
    @Autowired
    EmpBasicSerice empBasicSerice;
    @Autowired
    PoliticsstatusService politicsstatusService;//政治
    @Autowired
    NationService nationService;//民族
    @Autowired
    PositionService positionService;//职位
    @Autowired
    JobLevelService jobLevelService;//职称
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public ResPageBean getPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee emp, Date[] beDate) {
        return empBasicSerice.getPage(page, size,emp,beDate);
    }
    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if(empBasicSerice.addEmp(employee)==1){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }
    @DeleteMapping("/{id}")
    public RespBean deleteEmp(@PathVariable Integer id){
        if(empBasicSerice.deleteEmp(id)==1){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee emp){
        if(empBasicSerice.updateEmp(emp)==1){
            return RespBean.ok("修改成功！");
        }else{
            return RespBean.error("修改失败！");
        }
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> empExport(){
        List<Employee> data = (List<Employee>)empBasicSerice.getPage(null, null,null,null).getData();
        return EmpExport.emp2Xls(data);
    }
    @PostMapping("/import")
    public RespBean importEmp(MultipartFile file) {
        List<Employee> empLost=POIUtils.excel2Emp(file,nationService.getAllNation(),politicsstatusService.getAllPoliticsstatus(),departmentService.getAllDepts(),
                positionService.getAllPositions(),jobLevelService.getAllJobLevels());
        if(empBasicSerice.addEmpList(empLost)==empLost.size()){
            return RespBean.ok("上传成功！");
        }else{
            return RespBean.error("上传失败！");
        }

    }



    @GetMapping("/po")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }
    @GetMapping("/pos")
    public List<Position> getAllPosition(){
        return positionService.getAllPositions();
    }
    @GetMapping("/nation")
    public List<Nation> getAllNation(){
        return nationService.getAllNation();
    }
    @GetMapping("/job")
    public List<JobLevel> getJobLevel(){
        return jobLevelService.getAllJobLevels();
    }
    @PostMapping("/maxid")
    public RespBean getWorkID(){
        RespBean respBean = RespBean.build().setStatus(200).setObj(String.format("%08d", empBasicSerice.getWorkIDMax() + 1));
        return respBean;
    }
    @GetMapping("/dept")
    public List<Department> getAllDepmt(){
        return departmentService.getAllDeptById();
    }
}
