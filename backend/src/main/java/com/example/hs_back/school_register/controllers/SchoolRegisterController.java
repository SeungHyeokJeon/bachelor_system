package com.example.hs_back.school_register.controllers;

import com.example.hs_back.school_register.dtos.SchoolRegisterDTO;
import com.example.hs_back.school_register.sevices.SchoolRegisterService;
import com.example.hs_back.school_register.sevices.impl.SchoolRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SchoolRegisterController {
    @Autowired
    SchoolRegisterService schoolRegisterService;

    //select one
    @GetMapping(path="/schoolinfo/{id}", produces="application/json")
    public ResponseEntity<?> getSchoolRegisterById(@PathVariable("id") Long schoolId) {
        SchoolRegisterDTO dto = schoolRegisterService.findById(schoolId);
        if(dto==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }
}
