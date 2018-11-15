package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    //以占位符的方式发送id，并配置路径变量PathVariable
    @GetMapping(value = "/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping(value = "/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping(value = "/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
