package com.service.impl;

import com.entity.residentInfo.relative;
import com.entity.residentInfo.vm.relativeEntityCreateVM;
import com.mapper.residentInfo.relativeDao;
import com.service.relativeService;
import com.utils.Asserts;
import com.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class relativeServiceImpl implements relativeService {
    @Autowired
    private relativeDao relativedao;
    @Override
    @Transactional
    public Integer addRelative(relativeEntityCreateVM createVM){
        Asserts.validate(createVM, "residentEntityCreateVM");
        String name = createVM.getResidentName();
        Integer id = relativedao.getIdByName(name);
        if(id==null){
            return 0;
        }
        relative rel = EntityUtils.vm2Entity(createVM, relative.class);
        rel.setResidentId(id);
        relativedao.addRelative(rel);
        // 返回成功
        return 1;
    }
    @Override
    public Integer deleteById(int ID){
        Asserts.notEmpty(ID, "删除的资源不存在");
        return relativedao.deleteById(ID);
    }
}
