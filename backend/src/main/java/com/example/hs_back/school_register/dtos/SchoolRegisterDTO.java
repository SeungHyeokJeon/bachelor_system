package com.example.hs_back.school_register.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SchoolRegisterDTO {
    private Long school_id;
    private String name;
    private Integer hakjeok_gbcd;
    private String name_eng;
    private String name_hanja;
    private String college_name;
    private String department_name;
    private Date birth;
    private Integer phone_number;
    private Integer mobile_number;
    private String email;
}
