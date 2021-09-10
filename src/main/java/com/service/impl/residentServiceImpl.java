package com.service.impl;

import com.entity.residentInfo.resident;
import com.entity.residentInfo.vm.residentEntityCreateVM;
import com.entity.residentInfo.vm.residentSearchVM;
import com.entity.residentInfo.vm.residentUpdateVM;
import com.github.pagehelper.PageInfo;
import com.mapper.residentInfo.residentDao;
import com.service.residentService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class residentServiceImpl implements residentService {

    @Autowired
    private residentDao residentdao;
    @Override
    @Transactional
    public resident addResident(residentEntityCreateVM createVM){
        Asserts.validate(createVM, "residentEntityCreateVM");
        // Date now = new Date();
        resident re = EntityUtils.vm2Entity(createVM, resident.class);
        residentdao.addresident(re);
        return re;
    }
    @Override
    public Integer updateResident(residentUpdateVM updateVM){
        String name = updateVM.getResidentName();
        // 若存在，则直接修改
        resident r = residentdao.selectByName(name);
        System.out.println("数据库的数据" +  r.getTel1());
        if(r==null){
            return 0;
        }
        resident re = EntityUtils.vm2Entity(updateVM, resident.class);
        System.out.println("前端的数据" + re.getTel1());
        re.setResidentId(r.getResidentId());
        if(re.getResidentPhone()==null)  re.setResidentPhone(r.getResidentPhone());
        if(re.getTel1()==null)  re.setTel1(r.getTel1());
        if(re.getTel2()==null)  re.setTel2(r.getTel2());
        if(re.getWorkAddress()==null)  re.setWorkAddress(r.getWorkAddress());
        if(re.getWorkPhone()==null)  re.setWorkPhone(r.getWorkPhone());
        if(re.getWorkUnit()==null)  re.setWorkUnit(r.getWorkUnit());
        System.out.println("修改前端的数据" + re.getTel1());
        residentdao.updateResident(re);
        return 1;
    }
    @Override
    public resident selectResidentByName(residentSearchVM sVM){
        Asserts.validate(sVM, "residentEntitySelectVM");
        String name = sVM.getResidentName();
        resident re = residentdao.selectByName(name);
        System.out.println(re);
        return re;
    }
    @Override
    public Integer deleteById(int ID){
        Asserts.notEmpty(ID, "删除的资源不存在");
        return residentdao.deleteById(ID);
    }
    @Override
    public PageInfo<resident> selectResidentById(List<Integer> list){
        ArrayList<resident> lr = new ArrayList<resident>();
        //System.out.println(residentdao.selectById(list.get(0)).getResidentName());
        for (Integer li: list){
            lr.add(residentdao.selectById(li));
        }
        return new PageInfo<resident>(EntityUtils.entity2VMList(lr, resident.class));
    }
}
