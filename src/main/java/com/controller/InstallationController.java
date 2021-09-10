package com.controller;

import com.common.ApiResult;
import com.entity.installationControl.InstallationUseEntity;
import com.entity.installationControl.vm.*;
import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.github.pagehelper.PageInfo;
import com.service.InstallationControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "设施管理")
@CrossOrigin
public class InstallationController {
    @Autowired
    private InstallationControlService installationControlService;

    @PostMapping("/createInstallationControl")
    @ApiOperation("添加设施")
    @RequiresPermissions(value = {"installationControl_createInstallationControl", "administrator"}, logical = Logical.OR)
    public ApiResult createInstallationControl(InstallationControlEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入设施信息成功");
        installationControlService.createInstallationControl(createVM);
        return result;
    }

    @PostMapping("/createInUseControl")
    @ApiOperation("添加使用人员")
    @RequiresPermissions(value = {"useControl_createUseControl", "administrator"}, logical = Logical.OR)
    public ApiResult createUseControl(InstallationUseEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入使用人员信息成功");
        installationControlService.createInUseControl(createVM);
        return result;
    }

    @PutMapping("/updateInstallationTable")
    @ApiOperation("修改设施信息")
    @RequiresPermissions(value = {"installationTable_updateInstallationTable", "administrator"}, logical = Logical.OR)
    public ApiResult updateInstallationTable(InstallationControlEntityUpdateVM updateVM) {
        try {
            if(installationControlService.updateInstallationTable(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PutMapping("/updateInstallationUseTable")
    @ApiOperation("修改设施使用信息")
    @RequiresPermissions(value = {"installationUseTable_updateInstallationUseTable", "administrator"}, logical = Logical.OR)
    public ApiResult updateUserTable(InstallationUseEntityUpdateVM updateVM) {
        try {
            if(installationControlService.updateUserTable(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @DeleteMapping("/deleteInstallation")
    @ApiOperation("删除设施信息")
    @RequiresPermissions(value = {"installation_deleteInstallation", "administrator"}, logical = Logical.OR)
    public ApiResult deleteInstallation(String installation) {
        try {
            if(installationControlService.deleteInstallation(installation)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @DeleteMapping("/deleteInstallationUse")
    @ApiOperation("删除设施使用信息")
    @RequiresPermissions(value = {"installationUse_deleteInstallationUse", "administrator"}, logical = Logical.OR)
    public ApiResult deleteInstallationUse(String installation) {
        try {
            if(installationControlService.deleteInstallationUse(installation)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getInstallation")
    @ApiOperation("根据设施名称获取设施信息")
    @RequiresPermissions(value = {"installation_getInstallation", "administrator"}, logical = Logical.OR)
    public ApiResult selectInstallation(InstallationControlEntitySearchVM searchVM) throws Exception {
        return ApiResult.SUCCESS(installationControlService.selectInstallation(searchVM));
    }

    @GetMapping("/getInstallationInUse")
    @ApiOperation("根据设施名称获取设施使用信息")
    @RequiresPermissions(value = {"installationInUse_getInstallationInUse", "administrator"}, logical = Logical.OR)
    public ApiResult selectInstallationInUse(InstallationUseEntitySearchVM searchVM) throws Exception {
        return ApiResult.SUCCESS(installationControlService.selectAllUseMessage(searchVM));
    }
}
