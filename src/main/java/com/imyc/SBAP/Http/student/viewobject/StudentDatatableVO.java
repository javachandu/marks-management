package com.imyc.SBAP.Http.student.viewobject;

import java.util.List;

import com.imyc.SBAP.Http.student.viewobject.datatable.StudentRow;
import com.imyc.SBAP.Http.user.viewobject.datatable.UserRow;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain=true)
public class StudentDatatableVO {

	private Integer draw;
	private Long recordsTotal;
	private Long recordsFiltered;
	private List<StudentRow> data;
	
}
