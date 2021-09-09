package com.entity.rentalManagement.RentAndSale;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

public class RentAndSaleSearchVM {
    @Min(value = 1)
    private Integer page;
    private Integer limit;
    @ApiModelProperty("住户id")
    int residentId;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }
}
