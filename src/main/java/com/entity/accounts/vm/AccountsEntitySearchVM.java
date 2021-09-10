package com.entity.accounts.vm;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

public class AccountsEntitySearchVM {

    @Min(value = 1)
    private Integer page;
    private Integer limit;
    @ApiModelProperty("贷方编号")
    int credit;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
