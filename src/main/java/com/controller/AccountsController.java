package com.controller;

import com.common.ApiResult;
import com.entity.accounts.vm.AccountsEntityCreateVM;
import com.service.AccountsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "账款管理")
@CrossOrigin
public class AccountsController {
    @Autowired
    private AccountsService accountsService;

    @PostMapping("/createAccounts")
    @ApiOperation("添加缴费状态信息")
    @RequiresPermissions(value = {"accounts_createAccounts", "administrator"}, logical = Logical.OR)
    public ApiResult createAccounts(AccountsEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入新账款项信息成功");
        accountsService.createAccounts(createVM);
        return result;
    }

//    @GetMapping("/departmentList")
//    @ApiOperation("根据条件获取部门信息")
//    @RequiresPermissions(value = {"department_departmentList", "administrator"}, logical = Logical.OR)
//    public ApiResult<PageInfo<DepartmentEntityListVM>> departmentList(DepartmentEntitySearchVM searchVM) throws Exception {
//        return ApiResult.SUCCESS(departmentService.departmentList(searchVM));
//    }
//
//
//    @DeleteMapping("/deleteDepartment")
//    @ApiOperation("禁用/启用部门信息")
//    @RequiresPermissions(value = {"department_deleteDepartment", "administrator"}, logical = Logical.OR)
//    public ApiResult deleteByDepartmentId(String departmentIds) {
//        departmentService.deleteByDepartmentId(departmentIds);
//        return ApiResult.SUCCESS();
//    }
//
//    @PutMapping("/saveDepartment")
//    @ApiOperation("修改部门信息")
//    @RequiresPermissions(value = {"department_updateDepartment", "administrator"}, logical = Logical.OR)
//    public ApiResult updateDepartment(DepartmentEntityUpdateVM updateVM) {
//        departmentService.updateDepartment(updateVM);
//        return ApiResult.SUCCESS();
//    }
}
