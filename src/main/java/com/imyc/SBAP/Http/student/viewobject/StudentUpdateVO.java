package com.imyc.SBAP.Http.student.viewobject;

import java.util.List;

import com.imyc.SBAP.Http.role.viewobject.RoleVO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain=true)
public class StudentUpdateVO {

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
