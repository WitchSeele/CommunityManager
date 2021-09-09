package com.entity.residentInfo.vm;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class residentEntityCreateVM {
    @ApiModelProperty(value = "住户id", hidden = true, required = false)
    int residentId; // useless
    @ApiModelProperty("住户名字")
    String residentName;
    @ApiModelProperty("住户性别")
    String residentSex;
    @ApiModelProperty("宅点1(非必须项)")
    String tel1; // useless
    @ApiModelProperty("宅电2(非必须项)")
    String tel2;
    @ApiModelProperty("住户电话")
    String residentPhone;
    @ApiModelProperty("工作单位(非必须项)")
    String workUnit; // useless
    @ApiModelProperty("工作电话(非必须项)")
    String workPhone;
    @ApiModelProperty("工作地址(非必须项)")
    String workAddress;
    @ApiModelProperty("入住时间")
    Date checkInTime;

    public Date getCheckInTime() {
        return checkInTime;
    }

    public int getResidentId() {
        return residentId;
    }

    public String getResidentSex() {
        return residentSex;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getResidentPhone() {
        return residentPhone;
    }

    public String getTel1() {
        return tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public void setResidentPhone(String residentPhone) {
        this.residentPhone = residentPhone;
    }

    public void setResidentSex(String residentSex) {
        this.residentSex = residentSex;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }
}
