package com.mapper.accounts;

import com.entity.accounts.AccountsEntity;
import com.entity.accounts.vm.AccountsEntitySearchVM;
import com.entity.accounts.vm.AccountsEntityUpdateVM;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface AccountsDao {
    @Insert({"INSERT INTO accounts(accountingId,accountsName,accountsSort,accountsNumber,debit,credit,debitAmount,creditAmount,accountsTotal,accountingDate)" +
            "VALUES(#{accountingId},#{accountsName},#{accountsSort},#{accountsNumber},#{debit},#{credit},#{debitAmount},#{creditAmount},#{accountsTotal},#{accountingDate})"})

    int createAccounts(AccountsEntity accountsEntity);

    @Delete({"DELETE FROM accounts WHERE accountingId=#{accountingId,jdbcType=INTEGER}"})

    Integer deleteByAccountsId(@Param("accountingId") int accountingId);

    @Update({"UPDATE accounts SET accountsName=#{accountsName},accountsSort=#{accountsSort},accountsNumber=#{accountsNumber},debit=#{debit},debitAmount=#{debitAmount}" +
            ",credit=#{credit},creditAmount=#{creditAmount},accountsTotal=#{accountsTotal},accountingDate=#{accountingDate} WHERE accountingId=#{accountingId}"})

    Integer updateAccounts(AccountsEntity accountsEntity);

    @Select({"SELECT * FROM accounts WHERE accountingId=#{accountingId}"})

    AccountsEntity getAccountsByID(int accountingId);

    @Select({"SELECT * FROM accounts WHERE  credit=#{credit}"})
    List<AccountsEntity> selectAllByCredit(AccountsEntitySearchVM accountsEntitySearchVM);
}
