package com.imyc.SBAP.Http.student.services;

import com.imyc.SBAP.Http.student.dao.Student;
import com.imyc.SBAP.Http.student.services.dataprocess.StudentDPO;
import com.imyc.SBAP.Http.student.viewobject.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailsServiceImpl {

    private StudentDPO studentDAO;
	
	@Autowired
	public StudentDetailsServiceImpl(StudentDPO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
    public StudentVO loadStudentByRollNo(String rollNo)  {

        Optional<StudentVO> optionalUser = studentDAO.getStudentByRollNo(rollNo);
        if(optionalUser.isPresent()) {
			StudentVO student = optionalUser.get();
           return student;
        } else {
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }

    public List<Student> findAll(){
	    return studentDAO.findAll();
    }

}