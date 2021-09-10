package com.entity.installationControl.vm;

import io.swagger.annotations.ApiModelProperty;

public class InstallationUseEntitySearchVM {
    @ApiModelProperty("设施名称")
    String installation;

    public String getInstallation() {
        return installation;
    }

    public void setInstallation(String installation) {
        this.installation = installation;
    }
}
