package com.viplav.utils.spring.codegenerator.misc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employees {
    @Column(name = "HIRE_DATE")
    private String hireDate;
    @Column(name = "BIRTH_DATE")
    private String birthDate;
    @Id
    @Column(name = "EMP_NO")
    private Integer empNo;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
}