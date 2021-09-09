package com.service.rentalManagement;

import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RentAndSaleService {
    int insertRS(RentAndSaleEntity rentAndSaleEntity);

    int deleteRSById(int id);

    int updateRS(RentAndSaleEntity rentAndSaleEntity);

    List<RentAndSaleEntity> RSList();
}
