package com.service;

import com.entity.residentInfo.resident;
import com.entity.residentInfo.vm.residentEntityCreateVM;
import com.entity.residentInfo.vm.residentSearchVM;
import com.entity.residentInfo.vm.residentUpdateVM;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface residentService {
    resident addResident(residentEntityCreateVM createVM);
    Integer updateResident(residentUpdateVM updateVM);
    resident selectResidentByName(residentSearchVM sVM);
    Integer deleteById(int ID);
    PageInfo<resident> selectResidentById(List<Integer> list);
}
