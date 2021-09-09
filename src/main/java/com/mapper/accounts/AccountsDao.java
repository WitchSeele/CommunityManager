package com.mapper.accounts;

import com.entity.accounts.AccountsEntity;
import org.apache.ibatis.annotations.*;


@Mapper
public interface AccountsDao {
    @Insert({"INSERT INTO accounts(accountingId,accountsName,accountsSort,accountsNumber,debitAmount,creditAmount,accountsTotal,accountingDate)" +
            "VALUES(#{accountingId},#{accountsName},#{accountsSort},#{accountsNumber},#{debitAmount},#{creditAmount},#{accountsTotal},#{accountingDate})"})

    int createAccounts(AccountsEntity accountsEntity);

    @Select({"select id from accounts where accountsName=#{accountsName} "})
    String getAccountByName(String accountsName);
//
//    @SelectProvider(type = DepartmentProvider.class, method = "SelectDepartment")
//    /**etDepartmentIdByName
//     *@Description:动态可多条件查找department表，并返回所有相关行数据
//     *@Parameter:[params]
//     *@Return:java.util.LinkedList<com.chiy.supervisionsystem.entity.department.DepartmentEntity>
//     *@Author:NullUserException
//     *@Date:2021/1/7
//     *@Time:17:54
//     **/
//     List<DepartmentEntity> getDepartments(DepartmentEntitySearchVM searchVM);
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
