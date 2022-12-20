package com.example.hs_back.school_register.sevices.impl;

import com.example.hs_back.entities.SchoolRegisters;
import com.example.hs_back.school_register.dtos.SchoolRegisterDTO;
import com.example.hs_back.school_register.mappers.SchoolRegisterMapper;
import com.example.hs_back.school_register.mappers.SchoolRegisterMapper;
import com.example.hs_back.school_register.repositories.SchoolRegisterRepository;
import com.example.hs_back.school_register.sevices.SchoolRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolRegisterServiceImpl implements SchoolRegisterService {
    @Autowired
    private SchoolRegisterRepository schoolRegisterRepository;
    @Autowired
    private SchoolRegisterMapper schooRegisterMapper;

    // select one
    @Override
    public SchoolRegisterDTO findById(Long schoolId) {
        Optional<SchoolRegisters> entity = schoolRegisterRepository.findById(schoolId);
        SchoolRegisterDTO dto;
        if(entity.isPresent()) {
            dto = schooRegisterMapper.toDto(entity.get());
            return dto;
        } else {
            return null;
        }
    }
}
