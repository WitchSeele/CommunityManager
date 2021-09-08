package com.service.impl;

import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntityCreateVM;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.payStatus.vm.PayStatusEntityUpdateVM;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.payStatus.PayStatusDao;
import com.service.PayStatusService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//extends SnowflakerServiceHelper
@Service
public class PayStatusServiceImpl  implements PayStatusService {
    @Autowired
    private PayStatusDao payStatusDao;

    @Override
    @Transactional
    public void createPayStatus(PayStatusEntityCreateVM createVM){
        Asserts.validate(createVM, "PayStatusEntityCreateVM");

        PayStatusEntity payStatusEntity = EntityUtils.vm2Entity(createVM, PayStatusEntity.class);

        int amount;
        amount= createVM.getThisWater()- createVM.getLastWater()+
                createVM.getThisEle()- createVM.getLastEle()+
                createVM.getThisGas()-createVM.getLastGas()+
                createVM.getNet()+createVM.getParking()+createVM.getProperty();
        payStatusEntity.setAmount(amount);

        payStatusEntity.setWater(createVM.getThisWater()- createVM.getLastWater());
        payStatusEntity.setEle(createVM.getThisEle()- createVM.getLastEle());
        payStatusEntity.setGas(createVM.getThisGas()- createVM.getLastGas());

        payStatusDao.createPayStatus(payStatusEntity);
    }

    @Override
    public Integer deleteByPayStatusId(int payStatusId) {
        Asserts.notEmpty(payStatusId, "删除的资源不存在");

        return payStatusDao.deleteByPayStatusId(payStatusId);
    }

    @Override
    public Integer updatePayStatus(PayStatusEntityUpdateVM updateVM){
        Asserts.notEmpty(updateVM.getPayStatusId(), "修改的资源不存在");

        PayStatusEntity oldPayStatusEntity=payStatusDao.getPayStatusByID(updateVM.getPayStatusId());
        if(oldPayStatusEntity==null) return 0;

        PayStatusEntity payStatusEntity = EntityUtils.vm2Entity(updateVM, PayStatusEntity.class);

        if(updateVM.getLastWater()!=0&&updateVM.getThisWater()!=0&&updateVM.getThisWater()>=updateVM.getLastWater())
            payStatusEntity.setWater(updateVM.getThisWater()- updateVM.getLastWater());
        else{
            payStatusEntity.setLastWater(oldPayStatusEntity.getLastWater());
            payStatusEntity.setThisWater(oldPayStatusEntity.getThisWater());
            payStatusEntity.setWater(oldPayStatusEntity.getWater());
        }
        if(updateVM.getLastEle()!=0&&updateVM.getThisEle()!=0&&updateVM.getThisEle()>=updateVM.getLastEle())
            payStatusEntity.setEle(updateVM.getThisEle()- updateVM.getLastEle());
        else{
            payStatusEntity.setLastEle(oldPayStatusEntity.getLastEle());
            payStatusEntity.setThisEle(oldPayStatusEntity.getThisEle());
            payStatusEntity.setEle(oldPayStatusEntity.getEle());
        }
        if(updateVM.getLastGas()!=0&&updateVM.getThisGas()!=0&&updateVM.getThisGas()>=updateVM.getLastGas())
            payStatusEntity.setGas(updateVM.getThisGas()- updateVM.getLastGas());
        else{
            payStatusEntity.setLastGas(oldPayStatusEntity.getLastGas());
            payStatusEntity.setThisGas(oldPayStatusEntity.getThisGas());
            payStatusEntity.setGas(oldPayStatusEntity.getGas());
        }
        if(updateVM.getNet()==0)
            payStatusEntity.setNet(oldPayStatusEntity.getNet());
        if(updateVM.getParking()==0)
            payStatusEntity.setParking(oldPayStatusEntity.getParking());
        if(updateVM.getProperty()==0)
            payStatusEntity.setProperty(oldPayStatusEntity.getProperty());
        if(updateVM.getTollTime()==null)
            payStatusEntity.setTollTime(oldPayStatusEntity.getTollTime());
        if(updateVM.getTollMan()==null)
            payStatusEntity.setTollMan(oldPayStatusEntity.getTollMan());
        if(updateVM.getPayMethod()==null)
            payStatusEntity.setPayMethod(oldPayStatusEntity.getPayMethod());
        if(updateVM.getPayStatus()==null)
            payStatusEntity.setPayStatus(oldPayStatusEntity.getPayStatus());

        int amount;
        amount= payStatusEntity.getThisWater()- payStatusEntity.getLastWater()+
                payStatusEntity.getThisEle()- payStatusEntity.getLastEle()+
                payStatusEntity.getThisGas()-payStatusEntity.getLastGas()+
                payStatusEntity.getNet()+payStatusEntity.getParking()+payStatusEntity.getProperty();
        payStatusEntity.setAmount(amount);

        payStatusEntity.setPayStatusId(oldPayStatusEntity.getPayStatusId());
        payStatusDao.updatePayStatus(payStatusEntity);
        return 1;
    }

    @Override
    public PageInfo<PayStatusEntity> selectAllByResidentId(PayStatusEntitySearchVM payStatusEntitySearchVM) {
        if (payStatusEntitySearchVM.getPage() != null & payStatusEntitySearchVM.getLimit() != null) {
            PageHelper.startPage(payStatusEntitySearchVM.getPage(), payStatusEntitySearchVM.getLimit());
        }

        List<PayStatusEntity> list = payStatusDao.selectAllByResidentId(payStatusEntitySearchVM);

        return new PageInfo<PayStatusEntity>(EntityUtils.entity2VMList(list, PayStatusEntity.class));
    }
}
