package com.imyc.SBAP.Http.student.dto;

import com.imyc.SBAP.Base.valid.passwordValid.annotation.PasswordValueMatch;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Setter
@Getter
@Accessors(chain = true)
public class StudentCreateDTO {

    private int id;

    private String rollNo;

    private String name;

    private String phone;

    private String department;

    private Integer firstMidMarks;

    private Integer qone;

    private Integer qtwo;

    private Integer qthree;

    private Integer secondMidMarks;

    private Integer qfour;

    private Integer qfive;


    private Integer qsix;

}
