package com.mapper.payStatus;


import com.entity.payStatus.PayStatusEntity;
import org.apache.ibatis.annotations.*;


@Mapper
public interface PayStatusDao {
    @Insert({"INSERT INTO payStatus(residentId,residentName,lastWater,thisWater,lastEle,thisEle,lastGas,thisGas,net,parking,property,tollTime,tollMan,payMethod) " +
            "VALUES(#{residentId},#{residentName},#{lastWater},#{thisWater},#{lastEle},#{thisEle},#{lastGas},#{thisGas},#{net},#{parking},#{property},#{tollTime},#{tollMan},#{payMethod})"})

    int createPayStatus(PayStatusEntity payStatusEntity);

//    @Select({"select id from department where department_name=#{departmentName} "})
//    String getDepartmentIdByName(String departmentName);
//
//    @SelectProvider(type = DepartmentProvider.class, method = "SelectDepartment")
//    /**
//     *@Description:动态可多条件查找department表，并返回所有相关行数据
//     *@Parameter:[params]
//     *@Return:java.util.LinkedList<com.chiy.supervisionsystem.entity.department.DepartmentEntity>
//     *@Author:NullUserException
//     *@Date:2021/1/7
//     *@Time:17:54
//     **/
//    List<DepartmentEntity> getDepartments(DepartmentEntitySearchVM searchVM);
//
//    @UpdateProvider(type = DepartmentProvider.class, method = "UpdateDepartment")
//    /**
//     *@Description:动态更改department信息
//     *@Parameter:[departmentEntity]
//     *@Return:java.lang.Integer
//     *@Author:NullUserException
//     *@Date:2021/1/6DepartmentDao
//     *@Time:16:12
//     **/
//    Integer updateDepartment(DepartmentEntity departmentEntity);
//
//    @Delete({"update  department set state = if(state=1,2, 1) WHERE id=#{id}"})
//    /**
//     *@Description:通过ID删除部门信息
//     *@Parameter:[id]
//     *@Return:java.lang.Integer
//     *@Date:2021/1/11
//     **/
//    Integer deleteByDepartmentId(@Param("id") String id);
//
//
//    @Select({"SELECT * FROM department WHERE id=#{id}"})
//    /**
//     *@Description:根据部门ID查找部门详情，单位信息模块内部调用
//     *@Parameter:[id]
//     *@Return:com.chiy.supervisionsystem.entity.department.DepartmentEntity
//     *@Date:2021/1/11
//     **/
//    DepartmentEntity getDepartmentByID(String id);
}