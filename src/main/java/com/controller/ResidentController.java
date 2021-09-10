package com.controller;

import com.common.ApiResult;
import com.entity.residentInfo.position;
import com.entity.residentInfo.resident;
import com.entity.residentInfo.vm.relativeEntityCreateVM;
import com.entity.residentInfo.vm.residentEntityCreateVM;
import com.entity.residentInfo.vm.residentSearchVM;
import com.entity.residentInfo.vm.residentUpdateVM;
import com.github.pagehelper.PageInfo;
import com.service.positionService;
import com.service.relativeService;
import com.service.residentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
@Api(tags = "住户资料管理")
@CrossOrigin
public class ResidentController {
    @Autowired
    private residentService rService;
    @Autowired
    private positionService pService;
    @Autowired
    private relativeService relService;
    @PostMapping("/addResident")
    @ApiOperation("添加住户信息")
    @RequiresPermissions(value = {"resident_addResident", "administrator"}, logical = Logical.OR)
    public ApiResult createResident(residentEntityCreateVM createVM, position pos) {
        ApiResult result = new ApiResult("插入住户信息成功");
        resident re = rService.addResident(createVM);
        pService.addPosition(pos,re.getResidentId());
        return result;
    }
    @PostMapping("/addRelative")
    @ApiOperation("添加主户家属信息")
    @RequiresPermissions(value = {"relative_addRelative", "administrator"}, logical = Logical.OR)
    public ApiResult createRelative(relativeEntityCreateVM createVM) {
        try {
           if(relService.addRelative(createVM)==0){
               return ApiResult.FAILURE("无此住户信息");
           }
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }
    @PutMapping("/updateResident")
    @ApiOperation("修改住户基本信息")
    @RequiresPermissions(value = {"resident_updateResident", "administrator"}, logical = Logical.OR)
    public ApiResult updateResident(residentUpdateVM updateVM) {
        try {
            if(rService.updateResident(updateVM)<=0)
                return ApiResult.FAILURE("参数错误,修改失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }
    @GetMapping("/getResidentByName")
    @ApiOperation("根据用户姓名获取用户信息")
    @RequiresPermissions(value = {"resident_getResident", "administrator"}, logical = Logical.OR)
    public ApiResult<resident> selectResidentByName(residentSearchVM sVM) throws Exception {
        resident re = rService.selectResidentByName(sVM);
        if(re==null)    return null;
        return ApiResult.SUCCESS(re);
    }

    @DeleteMapping("/deleteResident")
    @ApiOperation("删除用户及其家属信息")
    @RequiresPermissions(value = {"Resident_deleteResident", "administrator"}, logical = Logical.OR)
    public ApiResult deleteByResidentId(int ID) {
        try {
            // 注意此处的顺序（fk）
            relService.deleteById(ID);
            pService.deleteById(ID);
            if(rService.deleteById(ID)<=0)
                return ApiResult.FAILURE("参数错误,删除失败");
        }catch (Exception e) {
            return ApiResult.FAILURE(e.getMessage());
        }
        return ApiResult.SUCCESS();
    }

    @GetMapping("/getResidentByQuarterId")
    @ApiOperation("根据小区号获得住户信息")
    @RequiresPermissions(value = {"resident_getResident2", "administrator"}, logical = Logical.OR)
    public ApiResult<PageInfo<resident>> selectResidentByQuarter(int QuarterId) throws Exception {
        List<Integer> list = pService.selectIdsByQaurterId(QuarterId);
        return ApiResult.SUCCESS(rService.selectResidentById(list));
    }
}



