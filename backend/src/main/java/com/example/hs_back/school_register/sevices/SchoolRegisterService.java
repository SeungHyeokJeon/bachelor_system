package com.example.hs_back.school_register.sevices;

import com.example.hs_back.school_register.dtos.SchoolRegisterDTO;

public interface SchoolRegisterService {
    public SchoolRegisterDTO findById(Long schooId);
}
