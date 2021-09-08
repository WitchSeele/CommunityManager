package com.controller;

import com.common.ApiResult;
import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntityCreateVM;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.payStatus.vm.PayStatusEntityUpdateVM;
import com.github.pagehelper.PageInfo;
import com.service.PayStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "缴费状态管理")
@CrossOrigin
public class PayStatusController {
    @Autowired
    private PayStatusService payStatusService;

    @PostMapping("/createPayStatus")
    @ApiOperation("添加缴费状态信息")
    @RequiresPermissions(value = {"payStatus_createPayStatus", "administrator"}, logical = Logical.OR)
    public ApiResult createPayStatus(PayStatusEntityCreateVM createVM) {
        ApiResult result = new ApiResult("插入新缴费状态信息成功");
        payStatusService.createPayStatus(createVM);
        return result;
    }

    @DeleteMapping("/deletePayStatus")
    @ApiOperation("删除缴费状态信息")
    @RequiresPermissions(value = {"payStatus_deletePayStatus", "administrator"}, logical = Logical.OR)
    public ApiResult deleteByPayStatusId(int payStatusId) {
        try {
            if(payStatusService.deleteByPayStatusId(payStatusId)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PutMapping("/updatePayStatus")
    @ApiOperation("修改缴费状态信息")
    @RequiresPermissions(value = {"payStatus_updatePayStatus", "administrator"}, logical = Logical.OR)
    public ApiResult updatePayStatus(PayStatusEntityUpdateVM updateVM) {
        try {
            if(payStatusService.updatePayStatus(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getPayStatusList")
    @ApiOperation("根据住户id获取缴费信息")
    @RequiresPermissions(value = {"payStatus_getPayStatusList", "administrator"}, logical = Logical.OR)
    public ApiResult<PageInfo<PayStatusEntity>> selectAllByResidentId(PayStatusEntitySearchVM payStatusEntitySearchVM) throws Exception {
        return ApiResult.SUCCESS(payStatusService.selectAllByResidentId(payStatusEntitySearchVM));
    }
}
