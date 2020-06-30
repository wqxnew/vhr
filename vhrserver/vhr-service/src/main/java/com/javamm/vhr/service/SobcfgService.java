package com.javamm.vhr.service;

import com.javamm.vhr.mapper.EmployeeMapper;
import com.javamm.vhr.model.Employee;
import com.javamm.vhr.model.ResPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SobcfgService {

    @Autowired
    EmployeeMapper employeeMapper;

    public ResPageBean getAllEmpWithSalary(Integer page, Integer size) {
        if(page!=null&&size!=null){
            page=(page-1)*size;
        }
        List<Employee> list = employeeMapper.getAllEmpWithSalary(page,size);
        ResPageBean rpb = new ResPageBean();
        rpb.setData(list);
        rpb.setTatol(employeeMapper.getTotal(null,null));
        return rpb;
    }

    public Integer updateByEidAndSid(Integer eid, Integer sid) {
        return employeeMapper.updateByEidAndSid(eid,sid);
    }
}
