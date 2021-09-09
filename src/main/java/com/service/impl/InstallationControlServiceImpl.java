package com.service.impl;

import com.entity.installationControl.InstallationControlEntity;
import com.entity.installationControl.InstallationUseEntity;
import com.entity.installationControl.vm.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.installationControl.InstallationControlDao;
import com.service.InstallationControlService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstallationControlServiceImpl implements InstallationControlService {
    @Autowired
    private InstallationControlDao installationControlDao;

    @Override
    @Transactional
    public void createInstallationControl(InstallationControlEntityCreateVM createVM){
        Asserts.validate(createVM, "InstallationControlEntityCreateVM");

        InstallationControlEntity installationControlEntity = EntityUtils.vm2Entity(createVM, InstallationControlEntity.class);

        installationControlEntity.setInstallation(createVM.getInstallation());
        installationControlEntity.setBuilder(createVM.getDirector());
        installationControlEntity.setPhoneNumber(createVM.getPhoneNumber());
        installationControlEntity.setDirector(createVM.getDirector());
        installationControlEntity.setDeliveryDate(createVM.getDeliveryDate());
        installationControlEntity.setManagement(createVM.getManagement());
        installationControlEntity.setAmount(createVM.getAmount());

        installationControlDao.createInstallationControl(installationControlEntity);
    }

    public void createInUseControl(InstallationUseEntityCreateVM createVM){
        Asserts.validate(createVM, "InstallationUseEntityCreateVM");

        InstallationUseEntity installationUseEntity = EntityUtils.vm2Entity(createVM, InstallationUseEntity.class);

        installationUseEntity.setInstallation(createVM.getInstallation());
        installationUseEntity.setUserName(createVM.getUserName());
        installationUseEntity.setUseTime(createVM.getUseTime());
        installationUseEntity.setUsersNumber(createVM.getUsersNumber());
        installationUseEntity.setUseState(createVM.getUseState());
        installationUseEntity.setUseAmount(createVM.getUseAmount());

        installationControlDao.createUseControl(installationUseEntity);
    }

    @Override
    public Integer updateInstallationTable(InstallationControlEntityUpdateVM updateVM){
        Asserts.notEmpty(updateVM.getInstallation(), "修改的资源不存在");

        InstallationControlEntity oldInstallationEntity = installationControlDao.getMessageByName(updateVM.getInstallation());

        if(oldInstallationEntity==null) return 0;

        InstallationControlEntity installationControlEntity = EntityUtils.vm2Entity(updateVM, InstallationControlEntity.class);

        if(updateVM.getBuilder()!=null){
            installationControlEntity.setBuilder(updateVM.getBuilder());
        }else{
            installationControlEntity.setBuilder(oldInstallationEntity.getBuilder());
        }
        if(updateVM.getPhoneNumber()!=null){
            installationControlEntity.setPhoneNumber(updateVM.getPhoneNumber());
        }else{
            installationControlEntity.setPhoneNumber(oldInstallationEntity.getPhoneNumber());
        }
        if(updateVM.getDirector()!=null) {
            installationControlEntity.setDirector(updateVM.getDirector());
        }else{
            installationControlEntity.setDirector(oldInstallationEntity.getDirector());
        }
        if(updateVM.getDeliveryDate()!=null){
            installationControlEntity.setDeliveryDate(updateVM.getDeliveryDate());
        }else{
            installationControlEntity.setDeliveryDate(oldInstallationEntity.getDeliveryDate());
        }
        if(updateVM.getManagement()!=null){
            installationControlEntity.setManagement(updateVM.getManagement());
        }else{
            installationControlEntity.setManagement(oldInstallationEntity.getManagement());
        }
        if(updateVM.getAmount()!=0){
            installationControlEntity.setAmount(updateVM.getAmount());
        }else{
            installationControlEntity.setAmount(oldInstallationEntity.getAmount());
        }

        installationControlDao.updateInstallationTable(installationControlEntity);
        return 1;
    }

    public Integer updateUserTable(InstallationUseEntityUpdateVM updateVM){
        Asserts.notEmpty(updateVM.getId(), "修改的资源不存在");

        InstallationUseEntity oldInstallationEntity = installationControlDao.getMessageByID(updateVM.getId());

        if(oldInstallationEntity==null) return 0;

        InstallationUseEntity installationUseEntity = EntityUtils.vm2Entity(updateVM, InstallationUseEntity.class);

        installationUseEntity.setId(updateVM.getId());
        if(updateVM.getInstallation()!=null){
            installationUseEntity.setInstallation(updateVM.getInstallation());
        }else{
            installationUseEntity.setInstallation(oldInstallationEntity.getInstallation());
        }
        if(updateVM.getUserName()!=null){
            installationUseEntity.setUserName(updateVM.getUserName());
        }else{
            installationUseEntity.setUserName(oldInstallationEntity.getUserName());
        }
        if(updateVM.getUseTime()!=null){
            installationUseEntity.setUseTime(updateVM.getUseTime());
        }else{
            installationUseEntity.setUseTime(oldInstallationEntity.getUseTime());
        }
        if(updateVM.getUsersNumber()>0){
            installationUseEntity.setUsersNumber(updateVM.getUsersNumber());
        }else{
            installationUseEntity.setUsersNumber(oldInstallationEntity.getUsersNumber());
        }
        if(updateVM.getUseState()==1 || updateVM.getUseState()==0){
            installationUseEntity.setUseState(updateVM.getUseState());
        }else{
            installationUseEntity.setUseState(oldInstallationEntity.getUseState());
        }
        if(updateVM.getUseAmount()>=0){
            installationUseEntity.setUseAmount(updateVM.getUseAmount());
        }else{
            installationUseEntity.setUseAmount(oldInstallationEntity.getUseAmount());
        }

        installationControlDao.updateUserTable(installationUseEntity);

        return 1;
    }

    @Override
    public Integer deleteInstallation(String installation){
        Asserts.notEmpty(installation, "删除的资源不存在");

        return installationControlDao.deleteInstallation(installation);
    }

    @Override
    public Integer deleteInstallationUse(String installation){
        Asserts.notEmpty(installation, "删除的资源不存在");

        return installationControlDao.deleteInstallationUse(installation);
    }

    @Override
    public InstallationControlEntity selectInstallation(InstallationControlEntitySearchVM searchVM){
        InstallationControlEntity installationEntity = installationControlDao.getMessageByName(searchVM.getInstallation());
        if(installationEntity==null) return null;
        else return installationEntity;
    }

    @Override
    public List<InstallationUseEntity> selectAllUseMessage(InstallationUseEntitySearchVM searchVM){
        List<InstallationUseEntity> installationEntityList = installationControlDao.getAllUseMessage(searchVM.getInstallation());
        if(installationEntityList==null) return null;
        else return installationEntityList;
    }
}
