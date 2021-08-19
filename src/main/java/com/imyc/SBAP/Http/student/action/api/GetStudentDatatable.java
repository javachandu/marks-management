package com.imyc.SBAP.Http.student.action.api;

import com.imyc.SBAP.Base.dto.DatatableServerSideConfig;
import com.imyc.SBAP.Http.student.services.requester.contracts.StudentIndexRequester;
import com.imyc.SBAP.Http.student.viewobject.StudentDatatableVO;
import com.imyc.SBAP.Http.user.services.requester.contracts.UserIndexRequester;
import com.imyc.SBAP.Http.user.viewobject.UserDatatableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetStudentDatatable {

	private StudentIndexRequester userIndexContract;
	private DatatableServerSideConfig datatableServerSideConfig;

	@Autowired
	public GetStudentDatatable(@Qualifier("StudentDatatableProvider") StudentIndexRequester userIndexContract) {
		this.userIndexContract = userIndexContract;
	}

	@GetMapping("api/datatable/student")
	public ResponseEntity<StudentDatatableVO> handle(
			@RequestParam int draw, @RequestParam int start, @RequestParam int length, 
			@RequestParam(name="search[value]", required = false) String keyword) {

		datatableServerSideConfig = new DatatableServerSideConfig();
		datatableServerSideConfig
				.setDraw(draw)
				.setStart(start)
				.setLength(length)
				.setKeyword(keyword.trim());

		StudentDatatableVO result = userIndexContract.indexResponse(datatableServerSideConfig);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
