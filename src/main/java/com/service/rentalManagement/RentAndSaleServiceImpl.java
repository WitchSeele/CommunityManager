package com.service.rentalManagement;

import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.rentalManagement.RentAndSale.RentAndSaleEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.rentalManagement.RentAndSale.RSDao;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentAndSaleServiceImpl implements RentAndSaleService {
    @Autowired

    private RSDao rsDao;

    @Override
    public int insertRS(RentAndSaleEntity rentAndSaleEntity) {

        return rsDao.insertRS(rentAndSaleEntity);
    }

    @Override
    public int deleteRSById(int id) {
        Asserts.notEmpty(id, "删除的资源不存在");
        return rsDao.deleteRSById(id);
    }

    @Override
    public int updateRS(RentAndSaleEntity rentAndSaleEntity) {

        return rsDao.updateRS(rentAndSaleEntity);
    }

    @Override
    public List<RentAndSaleEntity> RSList() {
        return rsDao.RSList();
    }
}
