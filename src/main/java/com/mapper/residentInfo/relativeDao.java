package com.mapper.residentInfo;

import com.entity.residentInfo.relative;
import org.apache.ibatis.annotations.*;

@Mapper
public interface relativeDao {
    @Insert({"INSERT INTO relates " +
            "VALUES(#{residentId},#{relativeName},#{relativeSex},#{relativeRelation},#{workUnit}, #{workPhone}, #{workAddress}, #{residentPhone})"})
    void addRelative(relative rel);

    @Select({"SELECT id FROM residentinfo WHERE residentName =#{name}"})
    Integer getIdByName(String name);

    @Delete({"DELETE FROM relates WHERE resident_id=#{ID,jdbcType=INTEGER}"})
    Integer deleteById(@Param("ID") int ID);
}
