package com.mapper.residentInfo;

import com.entity.residentInfo.resident;
import org.apache.ibatis.annotations.*;

@Mapper
public interface residentDao {

    @Insert({"INSERT INTO residentinfo (id, residentName, residentSex, tel1, tel2,residentPhone,workUnit, workPhone, workAddress, checkInTime) " +
            "VALUES(#{id}, #{residentName},#{residentSex},#{tel1},#{tel2},#{residentPhone},#{workUnit}, #{workPhone}, #{workAddress}, #{checkInTime})"})
    // 将自增的id赋予re.residentId
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS VALUE",resultType = Integer.class, before = false, keyProperty = "id")
    void addresident(resident re);

    @Select({"SELECT id FROM residentinfo WHERE residentName =#{name}"})
    Integer getIdByName(String name);

    @Update({"UPDATE residentinfo SET tel1=#{tel1},tel2=#{tel2},residentPhone=#{residentPhone}, workUnit=#{workUnit}," +
            "workPhone=#{workPhone}, workAddress=#{workAddress} where id=#{id}"})
    Integer updateResident(resident re);

    @Select({"SELECT * FROM residentinfo  WHERE residentName=#{name}"})
    resident selectByName(String name);

    @Delete({"DELETE FROM residentinfo WHERE id=#{ID,jdbcType=INTEGER}"})
    Integer deleteById(@Param("ID") int ID);

    @Select({"SELECT * FROM residentinfo  WHERE id=#{id}"})
    resident selectById(@Param("id") int id);


}


