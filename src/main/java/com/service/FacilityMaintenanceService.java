package com.service;

import com.entity.facilityMaintenance.FacilityMaintenanceEntity;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityUpdateVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntitySearchVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityCreateVM;
import com.github.pagehelper.PageInfo;

public interface FacilityMaintenanceService {
    void createFacilityMaintenance(FacilityMaintenanceEntityCreateVM createVM);

    Integer deleteByInstallation(String installation);

    Integer updateFacilityMaintenance(FacilityMaintenanceEntityUpdateVM updateVM);

    PageInfo<FacilityMaintenanceEntity> selectAllByInstallation(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM);

    PageInfo<FacilityMaintenanceEntity> selectAll(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM);
}
