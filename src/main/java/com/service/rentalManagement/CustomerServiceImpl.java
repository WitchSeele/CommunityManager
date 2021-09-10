package com.service.rentalManagement;

import com.entity.rentalManagement.Customer.CustomerEntity;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.mapper.rentalManagement.Customer.CustomerDao;
import com.mapper.rentalManagement.RentAndSale.RSDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;
    @Override
    public int insertC(CustomerEntity customerEntity) {
        return customerDao.insertC(customerEntity);
    }

    @Override
    public int deleteCById(int c_id) {
        return customerDao.deleteCById(c_id);
    }

    @Override
    public int updateC(CustomerEntity customerEntity) {
        return customerDao.updateC(customerEntity);
    }

    @Override
    public List<CustomerEntity> CList() {
        return customerDao.CList();
    }

    @Override
    public CustomerEntity selectByID(int c_id) {
        return customerDao.selectByID(c_id);
    }

    @Override
    public List<CustomerEntity> selectByName(String c_name) {
        return customerDao.selectByName(c_name);
    }
}
