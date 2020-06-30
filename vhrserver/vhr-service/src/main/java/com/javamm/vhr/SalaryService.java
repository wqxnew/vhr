package com.javamm.vhr;

import com.javamm.vhr.mapper.SalaryMapper;
import com.javamm.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalary() {
        return salaryMapper.getAllSalary();

    }

    public Integer addSalaries(Salary salary) {
        if(salary.getCreatedate()==null){
            salary.setCreatedate(new Date());
        }
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalary(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalary(Salary salary) {
        salary.setCreatedate(new Date());
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
