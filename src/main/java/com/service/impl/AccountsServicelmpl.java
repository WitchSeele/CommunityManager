package com.service.impl;

import com.entity.accounts.AccountsEntity;
import com.entity.accounts.vm.AccountsEntityCreateVM;
import com.entity.accounts.vm.AccountsEntitySearchVM;
import com.entity.accounts.vm.AccountsEntityUpdateVM;
import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.payStatus.vm.PayStatusEntityUpdateVM;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.accounts.AccountsDao;
import com.service.AccountsService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Override
    public Integer deleteByAccountsId(int accountsId) {
        Asserts.notEmpty(accountsId, "删除的资源不存在");

        return accountsDao.deleteByAccountsId(accountsId);
    }

    @Override
    public Integer updateAccounts(AccountsEntityUpdateVM updateVM){
        Asserts.notEmpty(updateVM.getAccountingId(), "修改的资源不存在");

        AccountsEntity oldAccountsEntity=accountsDao.getAccountsByID(updateVM.getAccountingId());
        if(oldAccountsEntity==null) return 0;

        AccountsEntity accountsEntity = EntityUtils.vm2Entity(updateVM, AccountsEntity.class);

        if(updateVM.getAccountsName()!=null)
            accountsEntity.setAccountsName(updateVM.getAccountsName());
        else{
            accountsEntity.setAccountsName(oldAccountsEntity.getAccountsName());
        }
        if(updateVM.getAccountsSort()!=null)
            accountsEntity.setAccountsSort(updateVM.getAccountsSort());
        else{
            accountsEntity.setAccountsSort(oldAccountsEntity.getAccountsSort());
        }
        if(updateVM.getAccountsNumber()!=0)
            accountsEntity.setAccountsNumber(updateVM.getAccountsNumber());
        else{
            accountsEntity.setAccountsNumber(oldAccountsEntity.getAccountsNumber());
        }
        if(updateVM.getDebit()==0)
            accountsEntity.setDebit(oldAccountsEntity.getDebit());
        if(updateVM.getCredit()==0)
            accountsEntity.setCredit(oldAccountsEntity.getCredit());
        if(updateVM.getDebitAmount()==0)
            accountsEntity.setDebitAmount(oldAccountsEntity.getDebitAmount());
        if(updateVM.getCreditAmount()==0)
            accountsEntity.setCreditAmount(oldAccountsEntity.getCreditAmount());
        if(updateVM.getAccountsTotal()==0)
            accountsEntity.setAccountsTotal(oldAccountsEntity.getAccountsTotal());
        if(updateVM.getAccountingDate()==null)
            accountsEntity.setAccountingDate(oldAccountsEntity.getAccountingDate());

        accountsEntity.setAccountingId(oldAccountsEntity.getAccountingId());
        accountsDao.updateAccounts(accountsEntity);
        return 1;
    }

    @Override
    public PageInfo<AccountsEntity> selectAllByCredit(AccountsEntitySearchVM accountsEntitySearchVM) {
        if (accountsEntitySearchVM.getPage() != null & accountsEntitySearchVM.getLimit() != null) {
            PageHelper.startPage(accountsEntitySearchVM.getPage(), accountsEntitySearchVM.getLimit());
        }

        List<AccountsEntity> list = accountsDao.selectAllByCredit(accountsEntitySearchVM);

        return new PageInfo<AccountsEntity>(EntityUtils.entity2VMList(list, AccountsEntity.class));
    }
}
