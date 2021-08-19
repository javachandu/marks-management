package com.imyc.SBAP.Http.student.action;

import com.imyc.SBAP.Exception.web.WebPageNotFoundException;
import com.imyc.SBAP.Exception.web.WebUpdateDataException;
import com.imyc.SBAP.Http.student.dto.StudentUpdateDTO;
import com.imyc.SBAP.Http.student.services.requester.contracts.StudentUpdateRequester;
import com.imyc.SBAP.Http.student.viewobject.StudentUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imyc.SBAP.Http.user.dto.UserUpdateDTO;
import com.imyc.SBAP.Http.user.services.requester.contracts.UserUpdateRequester;
import com.imyc.SBAP.Http.user.viewobject.UserUpdateVO;

import javax.validation.Valid;

@Controller
public class StudentUpdate {
	
	private StudentUpdateRequester studentUpdateRequester;
	
	@Autowired
	public StudentUpdate(@Qualifier("StudentDatatableProvider") StudentUpdateRequester userUpdateRequester) {
		this.studentUpdateRequester = userUpdateRequester;
	}

	@GetMapping("/student/update/{id}")
	public ModelAndView render(@PathVariable(value="id") int id) throws WebPageNotFoundException {
		
		StudentUpdateVO studentUpdatVO = studentUpdateRequester.updateResponse(id);
		
		StudentUpdateDTO studentUpdateDTO = new StudentUpdateDTO();
		
		ModelAndView modelAndView = new ModelAndView("admin-panel/student/update");
		modelAndView.addObject("id", id);
		modelAndView.addObject("studentUpdateVO", studentUpdatVO);
		modelAndView.addObject("studentUpdateDTO", studentUpdateDTO);
		
		return modelAndView;
	}
	
	@PostMapping("/student/update/{id}")
	public String handle(@Valid @ModelAttribute StudentUpdateDTO studentUpdateDTO, @PathVariable(value="id") int id) throws WebUpdateDataException {

		studentUpdateRequester.updateRequest(studentUpdateDTO, id);

		return "redirect:/student?update=success";
	}
	
}
