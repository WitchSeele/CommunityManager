package com.service.rentalManagement;

import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;

import java.util.List;

public interface CustomerService {
    int insertC(CustomerEntity customerEntity);

    int deleteCById(int c_id);

    int updateC(CustomerEntity customerEntity);

    List<CustomerEntity> CList();
}
