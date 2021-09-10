package com.service.rentalManagement;

import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerService {
    int insertC(CustomerEntity customerEntity);

    int deleteCById(int c_id);

    int updateC(CustomerEntity customerEntity);

    List<CustomerEntity> CList();

    CustomerEntity selectByID(@Param("c_id")int c_id);

    List<CustomerEntity> selectByName(String c_name);
}
