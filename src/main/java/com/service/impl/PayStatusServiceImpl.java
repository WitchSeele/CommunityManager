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

import java.util.Date;
//extends SnowflakerServiceHelper
@Service
public class PayStatusServiceImpl  implements PayStatusService {
    @Autowired
    private PayStatusDao payStatusDao;

    @Override
    @Transactional
    public void createPayStatus(PayStatusEntityCreateVM createVM){
        Asserts.validate(createVM, "PayStatusEntityCreateVM");
        Date now = new Date();

        PayStatusEntity payStatusEntity = EntityUtils.vm2Entity(createVM, PayStatusEntity.class);

        payStatusEntity.setResidentId(createVM.getResidentId());
    }
}
