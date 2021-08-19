package com.imyc.SBAP.Http.student.action;

import com.imyc.SBAP.Http.student.services.requester.contracts.StudentDeleteRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.imyc.SBAP.Exception.web.WebDeleteDataException;
import com.imyc.SBAP.Http.user.services.requester.contracts.UserDeleteRequester;

@Controller
public class StudentDelete {

	private StudentDeleteRequester studentDeleteContract;
	
	@Autowired
	public StudentDelete(@Qualifier("StudentDatatableProvider") StudentDeleteRequester studentDeleteContract) {
		this.studentDeleteContract = studentDeleteContract;
	}
	
	@PostMapping("/student/delete/{id}")
	public String handle(@PathVariable(value="id") int id) throws WebDeleteDataException {
		studentDeleteContract.deleteRequest(id);
		return "redirect:/student?delete=success";
	}
	
}
