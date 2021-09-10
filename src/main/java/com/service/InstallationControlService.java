package com.service;

import com.entity.installationControl.InstallationControlEntity;
import com.entity.installationControl.InstallationUseEntity;
import com.entity.installationControl.vm.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InstallationControlService {
    void createInstallationControl(InstallationControlEntityCreateVM installationControlEntityCreateVM);
    void createInUseControl(InstallationUseEntityCreateVM installationUseEntityCreateVM);
    Integer updateInstallationTable(InstallationControlEntityUpdateVM installationControlEntityUpdateVM);
    Integer updateUserTable(InstallationUseEntityUpdateVM installationUseEntityUpdateVM);
    Integer deleteInstallation(String installation);
    Integer deleteInstallationUse(String installation);
    InstallationControlEntity selectInstallation(InstallationControlEntitySearchVM installationControlEntitySearchVM);
    List<InstallationUseEntity> selectAllUseMessage(InstallationUseEntitySearchVM installationUseEntitySearchVM);
}
