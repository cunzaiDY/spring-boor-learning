package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的Mapper
//@Mapper
public interface DepartmentMapper {

    //这里的CRUD是用注解完成的
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete * from department where id=#{id}")
    public int deleteDeptById(Integer id);

    //获取自增id，使用自动生成的主键，并且说明哪个属性封装主键
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) value(#{departmentName})")
    public int insertDept(Department department);

    @Update("update dpartment set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
