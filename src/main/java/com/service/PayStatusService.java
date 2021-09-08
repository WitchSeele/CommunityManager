package com.service;

import com.entity.payStatus.PayStatusEntity;
import com.entity.payStatus.vm.PayStatusEntityCreateVM;
import com.entity.payStatus.vm.PayStatusEntitySearchVM;
import com.entity.payStatus.vm.PayStatusEntityUpdateVM;
import com.github.pagehelper.PageInfo;

public interface PayStatusService {
    void createPayStatus(PayStatusEntityCreateVM createVM);

    Integer deleteByPayStatusId(int payStatusId);

    Integer updatePayStatus(PayStatusEntityUpdateVM updateVM);

    PageInfo<PayStatusEntity> selectAllByResidentId(PayStatusEntitySearchVM payStatusEntitySearchVM);
}
