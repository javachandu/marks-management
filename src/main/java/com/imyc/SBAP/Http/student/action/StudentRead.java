package com.imyc.SBAP.Http.student.action;

import com.imyc.SBAP.Exception.web.WebPageNotFoundException;
import com.imyc.SBAP.Http.student.viewobject.StudentReadVO;
import com.imyc.SBAP.Http.user.services.requester.contracts.UserReadRequester;
import com.imyc.SBAP.Http.user.viewobject.UserReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.imyc.SBAP.Http.student.services.requester.contracts.StudentReadRequester;

@Controller
public class StudentRead {

	private StudentReadRequester StudentReadRequester;
	
	@Autowired
	public StudentRead(@Qualifier("StudentDatatableProvider") StudentReadRequester userReadRequester) {
		this.StudentReadRequester = userReadRequester;
	}
	
	@GetMapping("/student/read/{id}")
	public ModelAndView render(@PathVariable(value="id") int id) throws WebPageNotFoundException {
		
		StudentReadVO studentReadVO = StudentReadRequester.readResponse(id);
		
		return new ModelAndView("admin-panel/student/read", "studentReadVO", studentReadVO);
	}
	
}
