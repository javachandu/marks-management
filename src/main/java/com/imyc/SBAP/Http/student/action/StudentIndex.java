package com.imyc.SBAP.Http.student.action;

import com.imyc.SBAP.Http.student.services.StudentDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentIndex {
	@Autowired
     StudentDetailsServiceImpl studentDetailsService;
	@GetMapping("/student")
	public String render(Model model) {
		model.addAttribute("students", studentDetailsService.findAll());
		return "admin-panel/student/index";
	}
	
}
