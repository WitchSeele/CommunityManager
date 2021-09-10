package com.entity.facilityMaintenance.vm;

import io.swagger.annotations.ApiModelProperty;
import org.apiguardian.api.API;

import javax.validation.constraints.Min;

public class FacilityMaintenanceEntitySearchVM {
    @Min(value = 1)
//    private Integer page;
//    private Integer limit;
    @ApiModelProperty("设施名称")
    String installation;



//    public Integer getPage() {
//        return page;
//    }
//
//    public void setPage(Integer page) {
//        this.page = page;
//    }
//
//    public Integer getLimit() {
//        return limit;
//    }
//
//    public void setLimit(Integer limit) {
//        this.limit = limit;
//    }

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }


}
