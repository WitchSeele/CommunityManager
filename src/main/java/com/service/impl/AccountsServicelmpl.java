package com.service.impl;

import com.entity.accounts.AccountsEntity;
import com.entity.accounts.vm.AccountsEntityCreateVM;
import com.mapper.accounts.AccountsDao;
import com.service.AccountsService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountsServicelmpl implements AccountsService {
    @Autowired
    private AccountsDao accountsDao;

    @Override
    @Transactional
    public void createAccounts(AccountsEntityCreateVM createVM){
        Asserts.validate(createVM, "AccountsEntityCreateVM");

        AccountsEntity accountsEntity = EntityUtils.vm2Entity(createVM, AccountsEntity.class);

//        int amount;
//        amount= createVM.getThisWater()- createVM.getLastWater()+
//                createVM.getThisEle()- createVM.getLastEle()+
//                createVM.getThisGas()-createVM.getLastGas()+
//                createVM.getNet()+createVM.getParking()+createVM.getProperty();
//        payStatusEntity.setAmount(amount);

        accountsDao.createAccounts(accountsEntity);
    }
}
