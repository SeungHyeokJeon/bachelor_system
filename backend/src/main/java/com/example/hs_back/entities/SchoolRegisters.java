package com.example.hs_back.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "school_register")
public class SchoolRegisters {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="school_id")
    private Long schoolId;

    @Column(name="name", nullable=false) // not null
    private String name;

    @Column(name="hakjeok_gbcd")
    private Integer hakjeokGbcd;

    @Column(name="name_eng")
    private String nameEng;

    @Column(name="name_hanja")
    private String nameHanja;

    @Column(name="college_name")
    private String collegeName;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="birth")
    private Date birth;

    @Column(name="phone_number")
    private Integer phoneNumber;

    @Column(name="mobile_number")
    private Integer mobileNumber;

    @Column(name="email")
    private String email;
}