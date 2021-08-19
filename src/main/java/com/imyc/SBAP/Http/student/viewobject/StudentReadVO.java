package com.imyc.SBAP.Http.student.viewobject;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
public class StudentReadVO {

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