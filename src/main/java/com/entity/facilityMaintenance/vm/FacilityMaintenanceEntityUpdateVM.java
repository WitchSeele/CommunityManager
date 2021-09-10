package com.entity.facilityMaintenance.vm;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FacilityMaintenanceEntityUpdateVM {
    @NotNull
    @ApiModelProperty("设备名称(notNull)")
    String installation;
    @ApiModelProperty("维护人员")
    String mainStaff;
    @ApiModelProperty("电话")
    String telephone ;
    @ApiModelProperty("维护时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    Date mainTime;
    @ApiModelProperty("设施平面图")
    String facilityPlan;
    @ApiModelProperty("维护费用")
    int mainCost;
    @ApiModelProperty("管理人员")
    String managerStaff;
    @ApiModelProperty("维护说明")
    String mainExplain;

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }

    public String getMainStaff() {
        return mainStaff;
    }

    public void setMainStaff(String mainStaff) {
        this.mainStaff = mainStaff;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getMainTime() {
        return mainTime;
    }

    public void setMainTime(Date mainTime) {
        this.mainTime = mainTime;
    }

    public String getFacilityPlan() {
        return facilityPlan;
    }

    public void setFacilityPlan(String facilityPlan) {
        this.facilityPlan = facilityPlan;
    }

    public int getMainCost() {
        return mainCost;
    }

    public void setMainCost(int mainCost) {
        this.mainCost = mainCost;
    }

    public String getManagerStaff() { return managerStaff; }

    public void setManagerStaff(String managerStaff) { this.managerStaff = managerStaff; }

    public String getMainExplain() {
        return mainExplain;
    }

    public void setMainExplain(String mainExplain) {
        this.mainExplain = mainExplain;
    }
}
