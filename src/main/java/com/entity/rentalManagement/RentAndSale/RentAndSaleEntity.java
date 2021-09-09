package com.entity.rentalManagement.RentAndSale;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

public class RentAndSaleEntity implements Serializable {
    @ApiModelProperty("租售ID")
    int id;
    @ApiModelProperty("租售姓名")
    String rs_name;
    @ApiModelProperty("租售类型：出租|销售")
    String rs_rs;
    @ApiModelProperty("租售类型")
    String rs_type;
    @ApiModelProperty("租售地址")
    String rs_address;
    @ApiModelProperty("租售内容")
    String rs_content;
    @ApiModelProperty("租售时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    Date rs_time;

    @Override
    public String toString() {
        return "RentAndSaleEntity{" +
                "id=" + id +
                ", rs_name='" + rs_name + '\'' +
                ", rs_rs='" + rs_rs + '\'' +
                ", rs_type='" + rs_type + '\'' +
                ", rs_address='" + rs_address + '\'' +
                ", rs_content='" + rs_content + '\'' +
                ", rs_time=" + rs_time +
                '}';
    }

    public RentAndSaleEntity(int id, String rs_name, String rs_rs, String rs_type, String rs_address, String rs_content, Date rs_time) {
        this.id = id;
        this.rs_name = rs_name;
        this.rs_rs = rs_rs;
        this.rs_type = rs_type;
        this.rs_address = rs_address;
        this.rs_content = rs_content;
        this.rs_time = rs_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRs_name() {
        return rs_name;
    }

    public void setRs_name(String rs_name) {
        this.rs_name = rs_name;
    }

    public String getRs_rs() {
        return rs_rs;
    }

    public void setRs_rs(String rs_rs) {
        this.rs_rs = rs_rs;
    }

    public String getRs_type() {
        return rs_type;
    }

    public void setRs_type(String rs_type) {
        this.rs_type = rs_type;
    }

    public String getRs_address() {
        return rs_address;
    }

    public void setRs_address(String rs_address) {
        this.rs_address = rs_address;
    }

    public String getRs_content() {
        return rs_content;
    }

    public void setRs_content(String rs_content) {
        this.rs_content = rs_content;
    }

    public Date getRs_time() {
        return rs_time;
    }

    public void setRs_time(Date rs_time) {
        this.rs_time = rs_time;
    }
}
