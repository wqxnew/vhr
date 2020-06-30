package com.javamm.vhr.mapper;

import com.javamm.vhr.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getPage(@Param("page") Integer page,@Param("size") Integer size,@Param("emp")Employee emp, @Param("beDate")Date[] beDate);

    Long getTotal(@Param("emp")Employee emp, @Param("beDate") Date[] beDate);

    Integer getWorkIDMax();

    Integer addEmpList(@Param("list") List<Employee> empLost);

    Employee selectByKey(Integer id);

    List<Employee> getAllEmpWithSalary(@Param("page") Integer page,@Param("size") Integer size);

    Integer updateByEidAndSid(@Param("eid") Integer eid,@Param("sid") Integer sid);
}