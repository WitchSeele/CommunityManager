package com.controller;

import com.common.ApiResult;
import com.entity.facilityMaintenance.FacilityMaintenanceEntity;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityCreateVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntitySearchVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityUpdateVM;
import com.github.pagehelper.PageInfo;
import com.service.FacilityMaintenanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "设施维护管理")
@CrossOrigin
public class FacilityMaintenanceController {
    @Autowired
    private FacilityMaintenanceService facilityMaintenanceService;

    @PostMapping("/createFacilityMaintenance")
    @ApiOperation("添加维护情况")
    @RequiresPermissions(value = {"facilityMaintenance_createFacilityMaintenance", "administrator"}, logical = Logical.OR)
    public ApiResult createFacilityMaintenance(FacilityMaintenanceEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入新设施成功");
        facilityMaintenanceService.createFacilityMaintenance(createVM);
        return result;
    }

    @DeleteMapping("/deleteFacilityMaintenance")
    @ApiOperation("删除指定设施维护情况")
    @RequiresPermissions(value = {"facilityMaintenance_deleteFacilityMaintenance", "administrator"}, logical = Logical.OR)
    public ApiResult deleteByFacilityMaintenanceId(String installation) {
        try {
            if(facilityMaintenanceService.deleteByInstallation(installation)==null)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PutMapping("/updateFacilityMaintenance")
    @ApiOperation("修改设施维护情况")
    @RequiresPermissions(value = {"facilityMaintenance_updateFacilityMaintenance", "administrator"}, logical = Logical.OR)
    public ApiResult updateFacilityMaintenance(FacilityMaintenanceEntityUpdateVM updateVM) {
        try {
            if(facilityMaintenanceService.updateFacilityMaintenance(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getFacilityMaintenanceList")
    @ApiOperation("查询")
    @RequiresPermissions(value = {"facilityMaintenance_getFacilityMaintenanceList", "administrator"}, logical = Logical.OR)
    public ApiResult<PageInfo<FacilityMaintenanceEntity>> selectAllByInstallation(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM) throws Exception {
        return ApiResult.SUCCESS(facilityMaintenanceService.selectAllByInstallation(facilityMaintenanceEntitySearchVM));
    }

    @GetMapping("/getFacilityMaintenanceList2")
    @ApiOperation("获取全部信息")
    @RequiresPermissions(value = {"facilityMaintenance_getFacilityMaintenanceList2", "administrator"}, logical = Logical.OR)
    public ApiResult<PageInfo<FacilityMaintenanceEntity>> selectAll(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM) throws Exception {
        return ApiResult.SUCCESS(facilityMaintenanceService.selectAll(facilityMaintenanceEntitySearchVM));
    }
}
