package com.service;

import com.entity.residentInfo.position;

import java.util.List;

public interface positionService {
    void addPosition(position pos, int id);
    void deleteById(int ID);
    List<Integer> selectIdsByQaurterId(int QuarterId);
}
