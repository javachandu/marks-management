package com.imyc.SBAP.Http.student.services.dataprocess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.imyc.SBAP.Base.dto.DatatableServerSideConfig;
import com.imyc.SBAP.Http.student.dao.Student;
import com.imyc.SBAP.Http.student.dao.repository.StudentRepository;
import com.imyc.SBAP.Http.student.dao.repository.StudentSpecification;
import com.imyc.SBAP.Http.student.dto.StudentCreateDTO;
import com.imyc.SBAP.Http.student.dto.StudentUpdateDTO;
import com.imyc.SBAP.Http.student.viewobject.StudentDatatableVO;
import com.imyc.SBAP.Http.student.viewobject.StudentReadVO;
import com.imyc.SBAP.Http.student.viewobject.StudentUpdateVO;
import com.imyc.SBAP.Http.student.viewobject.datatable.StudentRow;
import com.imyc.SBAP.Http.user.dto.UserUpdateDTO;
import com.imyc.SBAP.Http.user.viewobject.UserUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.imyc.SBAP.Http.role.dao.Role;
import com.imyc.SBAP.Http.role.dao.repository.RoleRepository;
import com.imyc.SBAP.Http.role.viewobject.RoleVO;
import com.imyc.SBAP.Http.user.dao.User;
import com.imyc.SBAP.Http.user.dao.repository.UserRepository;
import com.imyc.SBAP.Http.user.dao.repository.UserSpecification;
import com.imyc.SBAP.Http.user.dto.UserCreateDTO;
import com.imyc.SBAP.Http.user.viewobject.UserCreateVO;
import com.imyc.SBAP.Http.user.viewobject.UserDatatableVO;
import com.imyc.SBAP.Http.user.viewobject.UserReadVO;
import com.imyc.SBAP.Http.user.viewobject.datatable.UserRow;
import com.imyc.SBAP.config.repositroy.SearchCriteria;

@Repository
public class StudentDatatableDPO {

	private StudentRepository studentRepo;

	@Autowired
	public StudentDatatableDPO(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	public StudentDatatableVO getStudentDatatableVO(DatatableServerSideConfig datatableServerSideConfig) {

		int draw = (int) datatableServerSideConfig.getDraw();
		int start = (int) datatableServerSideConfig.getStart();
		int length = (int) datatableServerSideConfig.getLength();
		String keyword = (String) datatableServerSideConfig.getKeyword();

		StudentDatatableVO userDatatableVO = new StudentDatatableVO();
		List<StudentRow> userRowList = new ArrayList<>();

		StudentSpecification spec1 = new StudentSpecification(new SearchCriteria("name", ":", keyword));
		StudentSpecification spec2 = new StudentSpecification(new SearchCriteria("rollNo", ":", keyword));

		Pageable pageRequest = PageRequest.of(start, length);
		//Page<Student> allUser = studentRepo.findAll(pageRequest);
		Page<Student> allUser = studentRepo.findAll(Specification.where(spec1).or(spec2), pageRequest);

		for(Student student : allUser) {
			StudentRow studentRow = new StudentRow();
			studentRow.setId(student.getId())
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

			userRowList.add(studentRow);
		}

		userDatatableVO
				.setDraw(draw)
				.setRecordsTotal(allUser.getTotalElements())
				.setRecordsFiltered(allUser.getTotalElements())
				.setData(userRowList);

		return userDatatableVO;
	}

	// Read

	public Optional<StudentReadVO> getStudentDetailForRead(int id) {

		Optional<Student> optionalUser = studentRepo.findById(id);

		if (optionalUser.isPresent()) {
			Student student = optionalUser.get();
			StudentReadVO studentReadVO = new StudentReadVO();

			studentReadVO.setId(student.getId())
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
			return Optional.of(studentReadVO);
		}else{
			return Optional.empty();
		}
	}

	// Delete

	public boolean deleteStudentWithRelationById(int id) {
		boolean isExist = studentRepo.existsById(id);
		if (isExist) {
			studentRepo.deleteById(id);
		}else {
			return false;
		}
		return true;
	}
	
	public boolean studentCreate(StudentCreateDTO student) {
		Student studentObj = new Student();
		studentObj.setId(student.getId())
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
			
		studentRepo.save(studentObj);
			
		return true;
	}

	// Update

	public Optional<StudentUpdateVO> getStudentForUpdate(int id) {

		Optional<Student> optionalStudent = studentRepo.findById(id);

		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();

			StudentUpdateVO studentUpdateVO = new StudentUpdateVO();
			studentUpdateVO.setId(student.getId())
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

			return Optional.of(studentUpdateVO);
		}else{
			return Optional.empty();
		}
	}

	public boolean studentUpdate(StudentUpdateDTO userUpdateDTO, int id) {
		Student student = new Student();
		studentRepo.save(student);
		return true;
	}
}
