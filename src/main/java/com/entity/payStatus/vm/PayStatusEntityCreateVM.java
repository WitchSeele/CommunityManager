package com.entity.payStatus.vm;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PayStatusEntityCreateVM {
    @NotNull
    @ApiModelProperty("住户id(notNull)")
    int residentId;
    @NotNull
    @ApiModelProperty("住户名字(notNull)")
    String residentName;
    @ApiModelProperty("上次水费基度")
    int lastWater;
    @ApiModelProperty("本次水费基度")
    int thisWater;
    @ApiModelProperty("上次电费基度")
    int lastEle;
    @ApiModelProperty("本次电费基度")
    int thisEle;
    @ApiModelProperty("上次气费基度")
    int lastGas;
    @ApiModelProperty("本次气费基度")
    int thisGas;
    @ApiModelProperty("光纤费")
    int net;
    @ApiModelProperty("停车费")
    int parking;
    @ApiModelProperty("物业费")
    int property;
    //@ApiModelProperty("收费时间")
    @ApiModelProperty("收费时间(eg.2020-02-05)")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    Date tollTime;
    @ApiModelProperty("收费人")
    String tollMan;
    @ApiModelProperty("支付方式")
    String payMethod;
    @ApiModelProperty("支付状态(0未支付，1已支付)")
    String payStatus;

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public int getLastWater() {
        return lastWater;
    }

    public void setLastWater(int lastWater) {
        this.lastWater = lastWater;
    }

    public int getThisWater() {
        return thisWater;
    }

    public void setThisWater(int thisWater) {
        this.thisWater = thisWater;
    }

    public int getLastEle() {
        return lastEle;
    }

    public void setLastEle(int lastEle) {
        this.lastEle = lastEle;
    }

    public int getThisEle() {
        return thisEle;
    }

    public void setThisEle(int thisEle) {
        this.thisEle = thisEle;
    }

    public int getLastGas() {
        return lastGas;
    }

    public void setLastGas(int lastGas) {
        this.lastGas = lastGas;
    }

    public int getThisGas() {
        return thisGas;
    }

    public void setThisGas(int thisGas) {
        this.thisGas = thisGas;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public Date getTollTime() {
        return tollTime;
    }

    public void setTollTime(Date tollTime) {
        this.tollTime = tollTime;
    }

    public String getTollMan() {
        return tollMan;
    }

    public void setTollMan(String tollMan) {
        this.tollMan = tollMan;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}
