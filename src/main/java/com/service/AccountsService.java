package com.service;

import com.entity.accounts.vm.AccountsEntityCreateVM;
import com.entity.accounts.AccountsEntity;
import com.entity.accounts.vm.AccountsEntitySearchVM;
import com.entity.accounts.vm.AccountsEntityUpdateVM;
import com.github.pagehelper.PageInfo;

public interface AccountsService {
    void createAccounts(AccountsEntityCreateVM createVM);
    Integer deleteByAccountsId(int accountsId);

    Integer updateAccounts(AccountsEntityUpdateVM updateVM);

    PageInfo<AccountsEntity> selectAllByCredit(AccountsEntitySearchVM accountsEntitySearchVM);

}
