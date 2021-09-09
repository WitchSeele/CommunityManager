package com.mapper.payStatus;


import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface PayStatusDao {
    @Insert({"INSERT INTO pay_status(residentId,residentName,lastWater,thisWater,water,lastEle,thisEle,ele" +
            ",lastGas,thisGas,gas,net,parking,property,amount,tollTime,tollMan,payMethod,payStatus) " +
            "VALUES(#{residentId},#{residentName},#{lastWater},#{thisWater},#{water},#{lastEle},#{thisEle},#{ele}" +
            ",#{lastGas},#{thisGas},#{gas},#{net},#{parking},#{property},#{amount},#{tollTime},#{tollMan},#{payMethod},#{payStatus})"})

    void createPayStatus(PayStatusEntity payStatusEntity);

    @Delete({"DELETE FROM pay_status WHERE payStatusId=#{payStatusId,jdbcType=INTEGER}"})

    Integer deleteByPayStatusId(@Param("payStatusId") int payStatusId);

    @Update({"UPDATE pay_status SET lastWater=#{lastWater},thisWater=#{thisWater},water=#{water},lastEle=#{lastEle}" +
            ",thisEle=#{thisEle},ele=#{ele},lastGas=#{lastGas},thisGas=#{thisGas},gas=#{gas}" +
            ",net=#{net},parking=#{parking},property=#{property},amount=#{amount},tollTime=#{tollTime}" +
            ",tollMan=#{tollMan},payMethod=#{payMethod},payStatus=#{payStatus} WHERE payStatusId=#{payStatusId}"})

    Integer updatePayStatus(PayStatusEntity payStatusEntity);

    @Select({"SELECT * FROM pay_status WHERE payStatusId=#{payStatusId}"})

    PayStatusEntity getPayStatusByID(int payStatusId);

    @Select({"SELECT * FROM pay_status WHERE  residentId=#{residentId}"})
    List<PayStatusEntity> selectAllByResidentId(PayStatusEntitySearchVM payStatusEntitySearchVM);

}
