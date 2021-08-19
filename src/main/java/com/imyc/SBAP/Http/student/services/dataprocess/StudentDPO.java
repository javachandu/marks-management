package com.imyc.SBAP.Http.student.services.dataprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.imyc.SBAP.Http.privilege.dao.Privilege;
import com.imyc.SBAP.Http.student.dao.Student;
import com.imyc.SBAP.Http.student.dao.repository.StudentRepository;
import com.imyc.SBAP.Http.student.viewobject.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imyc.SBAP.Http.role.dao.Role;
import com.imyc.SBAP.Http.user.dao.User;
import com.imyc.SBAP.Http.user.dao.repository.UserRepository;
import com.imyc.SBAP.Http.user.viewobject.UserVO;

@Repository
public class StudentDPO {

	private StudentRepository studentRepository;

	@Autowired
	public StudentDPO(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Optional<StudentVO> getStudentByRollNo(String rollNo) {

		Optional<Student> optionalUser = studentRepository.findByRollNo(rollNo);

		if (optionalUser.isPresent()) {
			Student student = optionalUser.get();


			StudentVO studentVo = new StudentVO();

			studentVo.setId(student.getId())
					.setDepartment(student.getDepartment())
					.setFirstMidMarks(student.getFirstMidMarks())
					.setSecondMidMarks(student.getSecondMidMarks())
					.setName(student.getName())
					.setPhone(student.getPhone())
					.setQfive(student.getQfive())
					.setQfour(student.getQfour())
					.setQthree(student.getQthree())
					.setQtwo(student.getQtwo())
					.setQone(student.getQone())
					.setQsix(student.getQsix())
					.setRollNo(student.getRollNo());
			
			return Optional.of(studentVo);
		}else{
			return Optional.empty();
		}
	}

	public List<Student> findAll(){
		return studentRepository.findAll();
	}
}
