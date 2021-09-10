package com.controller;

import com.common.ApiResult;
import com.entity.accounts.vm.AccountsEntityCreateVM;
import com.entity.accounts.AccountsEntity;
import com.entity.accounts.vm.AccountsEntitySearchVM;
import com.entity.accounts.vm.AccountsEntityUpdateVM;
import com.github.pagehelper.PageInfo;
import com.service.AccountsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "账款管理")
@CrossOrigin
public class AccountsController {
    @Autowired
    private AccountsService accountsService;

    @PostMapping("/createAccounts")
    @ApiOperation("添加账款项信息")
    @RequiresPermissions(value = {"accounts_createAccounts", "administrator"}, logical = Logical.OR)
    public ApiResult createAccounts(AccountsEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入新账款项信息成功");
        accountsService.createAccounts(createVM);
        return result;
    }
    @DeleteMapping("/deleteAccounts")
    @ApiOperation("删除账款项信息")
    @RequiresPermissions(value = {"accounts_deleteAccounts", "administrator"}, logical = Logical.OR)
    public ApiResult deleteByAccountsId(int accountsId) {
        try {
            if(accountsService.deleteByAccountsId(accountsId)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PutMapping("/updateAccounts")
    @ApiOperation("修改账款项信息")
    @RequiresPermissions(value = {"payStatus_updateAccounts", "administrator"}, logical = Logical.OR)
    public ApiResult updateAccounts(AccountsEntityUpdateVM updateVM) {
        try {
            if(accountsService.updateAccounts(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getAccountsList")
    @ApiOperation("根据贷方编号获取账款信息")
    @RequiresPermissions(value = {"accounts_getAccountsList", "administrator"}, logical = Logical.OR)
    public ApiResult<PageInfo<AccountsEntity>> selectAllByCredit(AccountsEntitySearchVM accountsEntitySearchVM) throws Exception {
        return ApiResult.SUCCESS(accountsService.selectAllByCredit(accountsEntitySearchVM));
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
