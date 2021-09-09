package com.controller.rentalManagement.RentAndSale;

import com.common.ApiResult;
import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.payStatus.vm.PayStatusEntityUpdateVM;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.github.pagehelper.PageInfo;
import com.service.rentalManagement.CustomerService;
import com.service.rentalManagement.RentAndSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "租售管理")
@CrossOrigin

public class RentAndSaleController {
    @Autowired
    private RentAndSaleService rentAndSaleService;

    @PostMapping("/InsertRS")
    @ApiOperation("添加租售信息")
    @RequiresPermissions(value = {"RentAndSaleEntity_insert", "administrator"}, logical = Logical.OR)
    public ApiResult insertRAS(RentAndSaleEntity rentAndSaleEntity) {
        try {
            if(rentAndSaleService.insertRS(rentAndSaleEntity)<=0)
                return ApiResult.FAILURE("参数错误,添加失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @DeleteMapping("/deleteRS")
    @ApiOperation("删除租售状态信息")
//    @RequiresPermissions(value = {"rentAndSaleEntity_delete", "administrator"}, logical = Logical.OR)
    public ApiResult deleteRSById(int id) {
        try {
            if(rentAndSaleService.deleteRSById(id)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PostMapping("/updateRS")
    @ApiOperation("修改租售状态信息")
//    @RequiresPermissions(value = {"payStatus_updatePayStatus", "administrator"}, logical = Logical.OR)
    public ApiResult updateRS(RentAndSaleEntity rentAndSaleEntity) {
        try {
            if(rentAndSaleService.updateRS(rentAndSaleEntity)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getRS")
    @ApiOperation("获取租售信息")
//    @RequiresPermissions(value = {"", "administrator"}, logical = Logical.OR)
    public ApiResult<List<RentAndSaleEntity>> selectAllRS() throws Exception {
        return ApiResult.SUCCESS(rentAndSaleService.RSList());
    }
}
