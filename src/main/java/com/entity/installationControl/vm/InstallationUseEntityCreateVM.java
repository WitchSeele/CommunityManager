package com.entity.installationControl.vm;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InstallationUseEntityCreateVM {
    @NotNull
    @ApiModelProperty("设施名称")
    String installation;
    @ApiModelProperty("使用人员名称")
    String userName;
    @ApiModelProperty(value = "使用时间(yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
    Date useTime;
    @ApiModelProperty("正在使用的人数")
    int usersNumber;
    @ApiModelProperty("使用状态(付费(0);免费(1))")
    int useState;
    @ApiModelProperty("使用金额")
    int useAmount;

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public int getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(int usersNumber) {
        this.usersNumber = usersNumber;
    }

    public int getUseState() {
        return useState;
    }

    public void setUseState(int useState) {
        this.useState = useState;
    }

    public int getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(int useAmount) {
        this.useAmount = useAmount;
    }
}
