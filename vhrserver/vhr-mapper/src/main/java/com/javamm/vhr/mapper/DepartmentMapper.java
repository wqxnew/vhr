package com.javamm.vhr.mapper;

import com.javamm.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDeptById(Integer pid);

    void addDep(Department dep);

    void deleteDep(Department dep);

    List<Department> getAllDepts();
}