package com.imyc.SBAP.Http.student.dao;



import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Accessors(chain=true)
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "roll_no", nullable = false)
    private String rollNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dept")
    private String department;

    @Column(name = "first_mid_marks")
    private Integer firstMidMarks;

    @Column(name = "qone")
    private Integer qone;

    @Column(name = "qtwo")
    private Integer qtwo;

    @Column(name = "qthree")
    private Integer qthree;

    @Column(name = "second_mid_marks")
    private Integer secondMidMarks;

    @Column(name = "qfour")
    private Integer qfour;

    @Column(name = "qfive")
    private Integer qfive;

    @Column(name = "qsix")
    private Integer qsix;
    
    public Student() {
        super();
    }

}