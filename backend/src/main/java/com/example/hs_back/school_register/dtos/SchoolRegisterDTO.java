package com.example.hs_back.school_register.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class SchoolRegisterDTO {
    private Long schoolId;
    private String name;
    private Integer hakjeokGbcd;
    private String nameEng;
    private String nameHanja;
    private String collegeName;
    private String departmentName;
    private Date birth;
    private Integer phoneNumber;
    private Integer mobileNumber;
    private String email;
}
