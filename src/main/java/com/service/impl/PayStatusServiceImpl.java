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

        int amount;
        amount= createVM.getThisWater()- createVM.getLastWater()+
                createVM.getThisEle()- createVM.getLastEle()+
                createVM.getThisGas()-createVM.getLastGas()+
                createVM.getNet()+createVM.getParking()+createVM.getProperty();
        payStatusEntity.setAmount(amount);

        payStatusDao.createPayStatus(payStatusEntity);
    }
}
