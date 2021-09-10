package com.service.impl;

import com.entity.residentInfo.position;
import com.mapper.residentInfo.positionDao;
import com.service.positionService;
import com.utils.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class PositionServiceImpl implements positionService {
    @Autowired
    private positionDao positiondao;
    String get_random(){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<3; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
    @Override
    @Transactional
    public void addPosition(position pos, int id){
        pos.setResident_id(id);
        Asserts.validate(pos, "positionBean");
        if(pos.getQuarter_id()==null){
            pos.setQuarter_id(get_random());
        }
        if(pos.getBuilding_id()==null){
            pos.setBuilding_id(get_random());
        }
        if(pos.getRoom_id()==null){
            pos.setRoom_id(get_random());
        }
        if(pos.getUnite_id()==null){
            pos.setUnite_id(get_random());
        }
        positiondao.addPosition(pos);
    }
    @Override
    public void deleteById(int ID){
        Asserts.notEmpty(ID, "删除的资源不存在");
        positiondao.deleteById(ID);
    }

    @Override
    public List<Integer> selectIdsByQaurterId(int QuarterId){
        Asserts.notEmpty(QuarterId, "删除的资源不存在");
        return positiondao.selectIdsByQaurterId(QuarterId);
    }
}
