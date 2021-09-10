package com.mapper.facilityMaintenance;

import com.entity.facilityMaintenance.FacilityMaintenanceEntity;
import com.entity.facilityMaintenance.vm.FacilityMaintenanceEntitySearchVM;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FacilityMaintenanceDao {
    @Insert({"INSERT INTO facility_maintenance(installation,mainStaff,telephone,mainTime,facilityPlan,mainCost,managerStaff,mainExplain)" +
            "VALUES(#{installation},#{mainStaff},#{telephone},#{mainTime},#{facilityPlan},#{mainCost},#{managerStaff},#{mainExplain})"})

    void createFacilityMaintenance(FacilityMaintenanceEntity facilityMaintenanceEntity);

    @Delete({"DELETE FROM facility_maintenance WHERE installation=#{installation,jdbcType=VARCHAR}"})

    Integer deleteByInstallation(@Param("installation") String installation);

    @Update({"UPDATE facility_maintenance SET mainStaff=#{mainStaff},telephone=#{telephone}"+
            ",mainTime=#{mainTime},facilityPlan=#{facilityPlan},mainCost=#{mainCost},managerStaff=#{managerStaff}"+
            ",mainExplain=#{mainExplain} WHERE installation=#{installation}"})

    Integer updateFacilityMaintenance(FacilityMaintenanceEntity facilityMaintenanceEntity);

    @Select({"SELECT * FROM facility_maintenance WHERE installation=#{installation}"})

    FacilityMaintenanceEntity getFacilityMaintenanceByInstallation(String installation);

    @Select({"SELECT * FROM facility_maintenance WHERE  installation=#{installation}"})
    List<FacilityMaintenanceEntity> selectAllByInstallation(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM);

    @Select({"SELECT * FROM facility_maintenance"})
    List<FacilityMaintenanceEntity> selectAll(FacilityMaintenanceEntitySearchVM facilityMaintenanceEntitySearchVM);



}
