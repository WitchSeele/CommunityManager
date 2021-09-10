package com.entity.accounts;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class AccountsEntity implements Serializable {
    @ApiModelProperty("账款id")
    int accountingId;
    @ApiModelProperty("账款名称")
    String accountsName;
    @ApiModelProperty("账款类别")
    String accountsSort;
    @ApiModelProperty("帐款号码")
    int accountsNumber;
    @ApiModelProperty("借方")
    int debit;
    @ApiModelProperty("贷方")
    int credit;
    @ApiModelProperty("借方数目")
    int debitAmount;
    @ApiModelProperty("贷方数目")
    int creditAmount;
    @ApiModelProperty("总计")
    int accountsTotal;
    @ApiModelProperty("账款日期")
    Date accountingDate;


    public int getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(int accountingId) {
        this.accountingId = accountingId;
    }

    public String getAccountsName() {
        return accountsName;
    }

    public void setAccountsName(String accountsName) {
        this.accountsName = accountsName;
    }

    public String getAccountsSort() {
        return accountsSort;
    }

    public void setAccountsSort(String accountsSort) {
        this.accountsSort = accountsSort;
    }

    public int getAccountsNumber() {
        return accountsNumber;
    }

    public void setAccountsNumber(int accountsNumber) {
        this.accountsNumber = accountsNumber;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {return credit; }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(int debitAmount) {
        this.debitAmount = debitAmount;
    }

    public int getCreditAmount() {return creditAmount; }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getAccountsTotal() {
        return accountsTotal;
    }

    public void setAccountsTotal(int accountsTotal) {
        this.accountsTotal = accountsTotal;
    }

    public Date getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }



}
