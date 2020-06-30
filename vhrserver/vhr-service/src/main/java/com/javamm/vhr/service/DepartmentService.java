package com.javamm.vhr.service;

import com.javamm.vhr.mapper.DepartmentMapper;
import com.javamm.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDeptById() {
        return departmentMapper.getAllDeptById(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }

    public void deleteDep(Department dep) {
//        dep.setEnabled(false);
        departmentMapper.deleteDep(dep);
    }

    public List<Department> getAllDepts() {
        return departmentMapper.getAllDepts();
    }
}
