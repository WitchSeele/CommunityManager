package com.entity.residentInfo.vm;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class relativeEntityCreateVM {
    @NotNull
    @ApiModelProperty("主户名字(必填)")
    String residentName;
    @ApiModelProperty("家属名字")
    String relativeName;
    @ApiModelProperty("家属性别")
    String relativeSex;
    @ApiModelProperty("家属关系")
    String relativeRelation; // useless
    @ApiModelProperty("家属电话")
    String residentPhone;
    @ApiModelProperty("工作单位")
    String workUnit; // useless
    @ApiModelProperty("工作电话")
    String workPhone;
    @ApiModelProperty("工作地址")
    String workAddress;

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    public String getRelativeSex() {
        return relativeSex;
    }

    public void setRelativeSex(String relativeSex) {
        this.relativeSex = relativeSex;
    }

    public String getRelativeRelation() {
        return relativeRelation;
    }

    public void setRelativeRelation(String relativeRelation) {
        this.relativeRelation = relativeRelation;
    }

    public String getResidentPhone() {
        return residentPhone;
    }

    public void setResidentPhone(String residentPhone) {
        this.residentPhone = residentPhone;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
