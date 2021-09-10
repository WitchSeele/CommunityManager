package com.service.impl;
import com.entity.facilityMaintenance.FacilityMaintenanceEntity;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityUpdateVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntitySearchVM;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntityCreateVM;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.facilityMaintenance.FacilityMaintenanceDao;
import com.service.FacilityMaintenanceService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class FacilityMaintenanceServiceImpl implements FacilityMaintenanceService{
    @Autowired
    private FacilityMaintenanceDao facilityMaintenanceDao;

    @Override
    @Transactional
    public void createFacilityMaintenance(FacilityMaintenanceEntityCreateVM createVM){
        Asserts.validate(createVM, "FacilityMaintenanceEntityCreateVM");

        FacilityMaintenanceEntity facilityMaintenanceEntity = EntityUtils.vm2Entity(createVM, FacilityMaintenanceEntity.class);

        facilityMaintenanceDao.createFacilityMaintenance(facilityMaintenanceEntity);
    }

    @Override
    public Integer deleteByInstallation(String installation) {
        Asserts.notEmpty(installation, "删除的资源不存在");

        return facilityMaintenanceDao.deleteByInstallation(installation);
    }

    @Override
    public Integer updateFacilityMaintenance(FacilityMaintenanceEntityUpdateVM updateVM){
        Asserts.notEmpty(updateVM.getInstallation(), "修改的资源不存在");

        FacilityMaintenanceEntity oldFacilityMaintenanceEntity=facilityMaintenanceDao.getFacilityMaintenanceByInstallation(updateVM.getInstallation());
        if(oldFacilityMaintenanceEntity==null) return 0;

        FacilityMaintenanceEntity facilityMaintenanceEntity = EntityUtils.vm2Entity(updateVM, FacilityMaintenanceEntity.class);

        if(updateVM.getMainStaff()==null)
            facilityMaintenanceEntity.setMainStaff(oldFacilityMaintenanceEntity.getMainStaff());
        if(updateVM.getTelephone()==null)
            facilityMaintenanceEntity.setTelephone(oldFacilityMaintenanceEntity.getTelephone());
        if(updateVM.getMainTime()==null)
            facilityMaintenanceEntity.setMainTime(oldFacilityMaintenanceEntity.getMainTime());
        if(updateVM.getFacilityPlan()==null)
            facilityMaintenanceEntity.setFacilityPlan(oldFacilityMaintenanceEntity.getFacilityPlan());
        if(updateVM.getMainCost()==0)
            facilityMaintenanceEntity.setMainCost(oldFacilityMaintenanceEntity.getMainCost());
        if(updateVM.getManagerStaff()==null)
            facilityMaintenanceEntity.setManagerStaff(oldFacilityMaintenanceEntity.getManagerStaff());
        if(updateVM.getMainExplain()==null)
            facilityMaintenanceEntity.setMainExplain(oldFacilityMaintenanceEntity.getMainExplain());
        facilityMaintenanceEntity.setInstallation(oldFacilityMaintenanceEntity.getInstallation());
        facilityMaintenanceDao.updateFacilityMaintenance(facilityMaintenanceEntity);
        return 1;
    }

    @Override
    public PageInfo<FacilityMaintenanceEntity> selectAllByInstallation(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM) {
//        if (facilityMaintenanceEntitySearchVM.getPage() != null & facilityMaintenanceEntitySearchVM.getLimit() != null) {
//            PageHelper.startPage(facilityMaintenanceEntitySearchVM.getPage(), facilityMaintenanceEntitySearchVM.getLimit());
//        }

        List<FacilityMaintenanceEntity> list = facilityMaintenanceDao.selectAllByInstallation(facilityMaintenanceEntitySearchVM);

        return new PageInfo<>(EntityUtils.entity2VMList(list, FacilityMaintenanceEntity.class));
    }
    @Override
    public PageInfo<FacilityMaintenanceEntity> selectAll(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM)
    {
        List<FacilityMaintenanceEntity> list = facilityMaintenanceDao.selectAll(facilityMaintenanceEntitySearchVM);

        return new PageInfo<>(EntityUtils.entity2VMList(list, FacilityMaintenanceEntity.class));
    }

}
