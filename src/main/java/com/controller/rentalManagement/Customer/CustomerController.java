package com.controller.rentalManagement.Customer;

import com.common.ApiResult;
import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.service.rentalManagement.CustomerService;
import com.service.rentalManagement.RentAndSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "客户购房管理")
@CrossOrigin


public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/InsertRS")
    @ApiOperation("添加客户信息")
//    @RequiresPermissions(value = {"RentAndSaleEntity_insert", "administrator"}, logical = Logical.OR)
    public ApiResult insertC(CustomerEntity customerEntity) {
        try {
            if(customerService.insertC(customerEntity)<=0)
                return ApiResult.FAILURE("参数错误,添加失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @DeleteMapping("/deleteRS")
    @ApiOperation("删除客户信息")
//    @RequiresPermissions(value = {"rentAndSaleEntity_delete", "administrator"}, logical = Logical.OR)
    public ApiResult deleteCById(int c_id) {
        try {
            if(customerService.deleteCById(c_id)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @PostMapping("/updateRS")
    @ApiOperation("修改客户信息")
//    @RequiresPermissions(value = {"payStatus_updatePayStatus", "administrator"}, logical = Logical.OR)
    public ApiResult updateC(CustomerEntity customerEntity) {
        try {
            if(customerService.updateC(customerEntity)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getRS")
    @ApiOperation("获取客户信息")
//    @RequiresPermissions(value = {"", "administrator"}, logical = Logical.OR)
    public ApiResult<List<CustomerEntity>> selectAllC() throws Exception {
        return ApiResult.SUCCESS(customerService.CList());
    }
}
