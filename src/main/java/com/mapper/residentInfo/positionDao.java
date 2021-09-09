package com.mapper.residentInfo;

import com.entity.residentInfo.position;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface positionDao {
    @Insert({"INSERT INTO householdpos() " +
            "VALUES(#{resident_id},#{quarter_id},#{building_id},#{unite_id},#{room_id})"})
    void addPosition(position pos);

    @Delete({"DELETE FROM householdpos WHERE resident_id=#{ID,jdbcType=INTEGER}"})
    void deleteById(@Param("ID") int ID);

    @Select({"SELECT resident_id FROM householdpos WHERE quarter_id =#{QuarterId, jdbcType=INTEGER}"})
    List<Integer> selectIdsByQaurterId(@Param("QuarterId") int QuarterId);
}
