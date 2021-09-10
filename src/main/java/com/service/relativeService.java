package com.service;

import com.entity.residentInfo.vm.relativeEntityCreateVM;

public interface relativeService {
    Integer addRelative(relativeEntityCreateVM createVM);
    Integer deleteById(int ID);
}
