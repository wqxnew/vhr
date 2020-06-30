package com.javamm.vhr.service;

import com.javamm.vhr.mapper.EmployeeMapper;
import com.javamm.vhr.model.Employee;
import com.javamm.vhr.model.ResPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class EmpBasicSerice {
    private final static Logger log =LoggerFactory.getLogger(EmpBasicSerice.class);
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat=new SimpleDateFormat("MM");
    DecimalFormat dcFormat=new DecimalFormat("##.00");

    public ResPageBean getPage(Integer page, Integer size,Employee emp, Date[] beDate) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        List<Employee> empList=employeeMapper.getPage(page,size,emp,beDate);
        Long total = employeeMapper.getTotal(emp,beDate);
        ResPageBean rpb = new ResPageBean();
        rpb.setData(empList);
        rpb.setTatol(total);
        return rpb;
    }

    public Integer addEmp(Employee employee) {
        Date begincontract = employee.getBegincontract();
        Date endcontract = employee.getEndcontract();
        double v = (Double.parseDouble(yearFormat.format(endcontract)) - Double.parseDouble(yearFormat.format(begincontract))) * 12 +
                (Double.parseDouble(monthFormat.format(endcontract)) - Double.parseDouble(monthFormat.format(begincontract)));
        employee.setContractterm(Double.parseDouble(dcFormat.format(v/12)));
        int result = employeeMapper.insertSelective(employee);
        if(result==1){
            Employee emp = employeeMapper.selectByKey(employee.getId());
            log.info("EmpBasicService.class....."+emp.toString());
            rabbitTemplate.convertAndSend("javamm.mail",emp);

        }
        return result;
    }

    public Integer getWorkIDMax() {
        return employeeMapper.getWorkIDMax();
    }

    public Integer deleteEmp(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee emp) {
        return employeeMapper.updateByPrimaryKeySelective(emp);
    }

    public Integer addEmpList(List<Employee> empLost) {
        return employeeMapper.addEmpList(empLost);
    }
}
