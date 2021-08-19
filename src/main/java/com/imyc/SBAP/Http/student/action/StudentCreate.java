package com.imyc.SBAP.Http.student.action;

import javax.validation.Valid;

import com.imyc.SBAP.Http.student.dto.StudentCreateDTO;
import com.imyc.SBAP.Http.student.services.requester.contracts.StudentCreateRequester;
import com.imyc.SBAP.Http.user.viewobject.StudentCreateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imyc.SBAP.Exception.web.WebCreateDataException;
import com.imyc.SBAP.Http.user.dto.UserCreateDTO;
import com.imyc.SBAP.Http.user.services.requester.contracts.UserCreateRequester;
import com.imyc.SBAP.Http.user.viewobject.UserCreateVO;

@Controller
public class StudentCreate {

	private StudentCreateRequester studentCreateRequester;
	
	@Autowired
	public StudentCreate(@Qualifier("StudentDatatableProvider") StudentCreateRequester studentCreateRequester) {
		this.studentCreateRequester = studentCreateRequester;
	}

	@GetMapping("/student/create")
	public ModelAndView render() {
		
		StudentCreateVO userCreateVO = studentCreateRequester.createResponse();

		StudentCreateDTO userCreateDTO = new StudentCreateDTO();
		
		ModelAndView modelAndView = new ModelAndView("admin-panel/student/create");
		modelAndView.addObject("studentCreateVO", userCreateVO);
		modelAndView.addObject("studentCreateDTO", userCreateDTO);
		
		return modelAndView;
	}
	
	@PostMapping("/student/create")
	public String handle(@Valid @ModelAttribute StudentCreateDTO userCreateDTO) throws WebCreateDataException {
		
		studentCreateRequester.createRequest(userCreateDTO);
		
		return "redirect:/student?create=success";
	}

}
