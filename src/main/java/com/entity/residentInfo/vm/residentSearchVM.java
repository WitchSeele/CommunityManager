package com.entity.residentInfo.vm;

import io.swagger.annotations.ApiModelProperty;

public class residentSearchVM {
    @ApiModelProperty("住户名字")
    String residentName;

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }
}
