package com.mapper.installationControl;

import com.entity.installationControl.InstallationControlEntity;
import com.entity.installationControl.InstallationUseEntity;
import com.entity.payStatus.PayStatusEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstallationControlDao {
    @Insert({"INSERT INTO installations(installation,builder,phoneNumber,director,deliveryDate,management,amount) " +
            "VALUES(#{installation},#{builder},#{phoneNumber},#{director},#{deliveryDate},#{management},#{amount})"})
    int createInstallationControl(InstallationControlEntity installationControlEntity);

    @Insert({"INSERT INTO use_of_installation(installation,userName,useTime,usersNumber,useState,useAmount) " +
            "VALUES(#{installation},#{userName},#{useTime},#{usersNumber},#{useState},#{useAmount})"})
    int createUseControl(InstallationUseEntity installationUseEntity);

    @Select({"SELECT * FROM installations WHERE installation=#{installation}"})
    InstallationControlEntity getMessageByName(String installation);

    @Select({"SELECT * FROM use_of_installation WHERE id=#{id}"})
    InstallationUseEntity getMessageByID(int id);

    @Update({"UPDATE installations SET builder=#{builder},phoneNumber=#{phoneNumber},director=#{director}" +
            ",deliveryDate=#{deliveryDate},management=#{management},amount=#{amount} WHERE installation=#{installation}"})
    Integer updateInstallationTable(InstallationControlEntity installationControlEntity);

    @Update({"UPDATE use_of_installation SET installation=#{installation},userName=#{userName},useTime=#{useTime}" +
            ",usersNumber=#{usersNumber},useState=#{useState},useAmount=#{useAmount} WHERE id=#{id}"})
    Integer updateUserTable(InstallationUseEntity installationUseEntity);

    @Delete({"DELETE FROM installations WHERE installation=#{installation,jdbcType=VARCHAR}"})
    Integer deleteInstallation(@Param("installation") String installation);

    @Delete({"DELETE FROM use_of_installation WHERE installation=#{installation,jdbcType=VARCHAR}"})
    Integer deleteInstallationUse(@Param("installation") String installation);

    @Select({"SELECT * FROM use_of_installation WHERE installation=#{installation}"})
    List<InstallationUseEntity> getAllUseMessage(String installation);
}
