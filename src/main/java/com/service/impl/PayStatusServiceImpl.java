package com.service.impl;

import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntityCreateVM;
import com.mapper.payStatus.PayStatusDao;
import com.service.PayStatusService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

        payStatusEntity.setResidentId(createVM.getResidentId());
        payStatusEntity.setResidentName(createVM.getResidentName());
        payStatusEntity.setLastWater(createVM.getLastWater());
        payStatusEntity.setThisWater(createVM.getThisWater());
        payStatusEntity.setLastEle(createVM.getLastEle());
        payStatusEntity.setThisEle(createVM.getThisEle());
        payStatusEntity.setLastGas(createVM.getLastGas());
        payStatusEntity.setThisGas(createVM.getThisGas());
        payStatusEntity.setNet(createVM.getNet());
        payStatusEntity.setParking(createVM.getParking());
        payStatusEntity.setProperty(createVM.getProperty());
        int amount;
        amount=createVM.getThisWater()- createVM.getLastWater()+
                createVM.getThisEle()- createVM.getLastEle()+
                createVM.getThisGas()-createVM.getLastGas()+
                createVM.getNet()+createVM.getParking()+createVM.getProperty();
        payStatusEntity.setAmount(amount);
        payStatusEntity.setTollTime(createVM.getTollTime());
        payStatusEntity.setTollMan(createVM.getTollMan());
        payStatusEntity.setPayMethod(createVM.getPayMethod());
        payStatusEntity.setPayStatus(createVM.getPayStatus());
        payStatusDao.createPayStatus(payStatusEntity);
    }
}
