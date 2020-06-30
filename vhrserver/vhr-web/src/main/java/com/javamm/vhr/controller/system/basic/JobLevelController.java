package com.javamm.vhr.controller.system.basic;

import com.javamm.vhr.model.JobLevel;
import com.javamm.vhr.model.RespBean;
import com.javamm.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if(jobLevelService.addJobLevel(jobLevel)==1){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if(jobLevelService.updateJobLevel(jobLevel)==1){
            return RespBean.ok("更新成功！");
        }else{
            return RespBean.error("更新失败！");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id){
        if(jobLevelService.deleteJobLevelById(id)==1){
            return RespBean.ok("删除成功！");

        }else{
            return RespBean.ok("删除失败！");
        }
    }
    @DeleteMapping("/")
    public RespBean deleteAllJobLevel(Integer[] ids){
        if(jobLevelService.deleteAllJobLevel(ids)==ids.length){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.ok("删除失败！");
        }
    }
}
