package com.service.rentalManagement;

import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentAndSaleService {
    int insertRS(RentAndSaleEntity rentAndSaleEntity);

    int deleteRSById(int id);

    int updateRS(RentAndSaleEntity rentAndSaleEntity);

    List<RentAndSaleEntity> RSList();

    RentAndSaleEntity selectByID(@Param("id")int id);

    List<RentAndSaleEntity> selectByName(String rs_name);

}
