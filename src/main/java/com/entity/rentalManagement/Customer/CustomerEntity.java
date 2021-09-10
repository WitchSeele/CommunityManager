package com.entity.rentalManagement.Customer;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CustomerEntity implements Serializable {
    @ApiModelProperty("客户ID")
    int c_id;
    @ApiModelProperty("客户姓名")
    String c_name;
    @ApiModelProperty("客户年龄")
    String c_age;
    @ApiModelProperty("客户职业")
    String c_occupation;
    @ApiModelProperty("客户电话")
    String c_contect;
    @ApiModelProperty("客户需求房型")
    String c_requirementType;
    @ApiModelProperty("客户需求大小")
    String c_requirementSize;
    @ApiModelProperty("客户预付金额")
    String c_prepaidAmount;
    @ApiModelProperty("客户地址")
    String c_address;
    @ApiModelProperty("房子用途")
    String c_use;

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", c_age='" + c_age + '\'' +
                ", c_occupation='" + c_occupation + '\'' +
                ", c_contect='" + c_contect + '\'' +
                ", c_requirementType='" + c_requirementType + '\'' +
                ", c_requirementSize='" + c_requirementSize + '\'' +
                ", c_prepaidAmount='" + c_prepaidAmount + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_use='" + c_use + '\'' +
                '}';
    }

    public CustomerEntity(int c_id, String c_name, String c_age, String c_occupation, String c_contect, String c_requirementType, String c_requirementSize, String c_prepaidAmount, String c_address, String c_use) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_age = c_age;
        this.c_occupation = c_occupation;
        this.c_contect = c_contect;
        this.c_requirementType = c_requirementType;
        this.c_requirementSize = c_requirementSize;
        this.c_prepaidAmount = c_prepaidAmount;
        this.c_address = c_address;
        this.c_use = c_use;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_age() {
        return c_age;
    }

    public void setC_age(String c_age) {
        this.c_age = c_age;
    }

    public String getC_occupation() {
        return c_occupation;
    }

    public void setC_occupation(String c_occupation) {
        this.c_occupation = c_occupation;
    }

    public String getC_contect() {
        return c_contect;
    }

    public void setC_contect(String c_contect) {
        this.c_contect = c_contect;
    }

    public String getC_requirementType() {
        return c_requirementType;
    }

    public void setC_requirementType(String c_requirementType) {
        this.c_requirementType = c_requirementType;
    }

    public String getC_requirementSize() {
        return c_requirementSize;
    }

    public void setC_requirementSize(String c_requirementSize) {
        this.c_requirementSize = c_requirementSize;
    }

    public String getC_prepaidAmount() {
        return c_prepaidAmount;
    }

    public void setC_prepaidAmount(String c_prepaidAmount) {
        this.c_prepaidAmount = c_prepaidAmount;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_use() {
        return c_use;
    }

    public void setC_use(String c_use) {
        this.c_use = c_use;
    }
}
