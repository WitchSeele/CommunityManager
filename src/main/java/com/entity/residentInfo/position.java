package com.entity.residentInfo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class position implements Serializable {
    @ApiModelProperty(value = "用户id", required = false, hidden = true)
    private int resident_id;
    @ApiModelProperty("小区编号(不填自动分配,三位)")
    private String quarter_id;
    @ApiModelProperty("楼宇编号(不填自动分配,三位)")
    private String building_id;
    @ApiModelProperty("单元编号(不填自动分配,三位)")
    private String unite_id;
    @ApiModelProperty("房间编号(不填自动分配,三位)")
    private String room_id;

    public int getResident_id() {
        return resident_id;
    }

    public void setResident_id(int resident_id) {
        this.resident_id = resident_id;
    }

    public String getQuarter_id() {
        return quarter_id;
    }

    public void setQuarter_id(String quarter_id) {
        this.quarter_id = quarter_id;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getUnite_id() {
        return unite_id;
    }

    public void setUnite_id(String unite_id) {
        this.unite_id = unite_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
}
