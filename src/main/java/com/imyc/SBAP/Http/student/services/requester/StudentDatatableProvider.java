package com.imyc.SBAP.Http.student.services.requester;

import com.imyc.SBAP.Base.dto.DatatableServerSideConfig;
import com.imyc.SBAP.Exception.web.WebCreateDataException;
import com.imyc.SBAP.Exception.web.WebDeleteDataException;
import com.imyc.SBAP.Exception.web.WebPageNotFoundException;
import com.imyc.SBAP.Exception.web.WebUpdateDataException;
import com.imyc.SBAP.Http.student.dto.StudentCreateDTO;
import com.imyc.SBAP.Http.student.dto.StudentUpdateDTO;
import com.imyc.SBAP.Http.student.services.dataprocess.StudentDatatableDPO;
import com.imyc.SBAP.Http.student.services.requester.contracts.*;
import com.imyc.SBAP.Http.student.viewobject.StudentDatatableVO;
import com.imyc.SBAP.Http.student.viewobject.StudentReadVO;
import com.imyc.SBAP.Http.student.viewobject.StudentUpdateVO;
import com.imyc.SBAP.Http.student.viewobject.StudentVO;
import com.imyc.SBAP.Http.user.dto.UserCreateDTO;
import com.imyc.SBAP.Http.user.dto.UserUpdateDTO;
import com.imyc.SBAP.Http.user.services.dataprocess.UserDatatableDPO;
import com.imyc.SBAP.Http.user.viewobject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier(value="StudentDatatableProvider")
public class StudentDatatableProvider implements StudentCreateRequester, StudentDeleteRequester,
		StudentIndexRequester, StudentReadRequester, StudentUpdateRequester {

	private StudentDatatableDPO studentDatatableDPO;

	@Autowired
	public StudentDatatableProvider(StudentDatatableDPO studentDatatableDPO) {
		this.studentDatatableDPO = studentDatatableDPO;
	}

	// Index
	
	@Override
	public StudentDatatableVO indexResponse(DatatableServerSideConfig datatableServerSideConfig) {
		StudentDatatableVO userDatatableVO = studentDatatableDPO.getStudentDatatableVO(datatableServerSideConfig);
		return userDatatableVO;
	}

	// Read
	
	@Override
	public StudentReadVO readResponse(int id) throws WebPageNotFoundException {

		Optional<StudentReadVO> optionalStudentReadVO = studentDatatableDPO.getStudentDetailForRead(id);

		if (optionalStudentReadVO.isPresent()) {
			return optionalStudentReadVO.get();
		} else {
			throw new WebPageNotFoundException();
		}
	}

	// Delete
	
	@Override
	public boolean deleteRequest(int id) throws WebDeleteDataException {

		boolean isDeleted = studentDatatableDPO.deleteStudentWithRelationById(id);
		
		if (isDeleted) {
			return true;
		} else {
			throw new WebDeleteDataException("Unable to delete: " + id);
		}
	}


	@Override
	public StudentCreateVO createResponse() {
		return null;
	}

	@Override
	public boolean createRequest(StudentCreateDTO userCreateDTO) throws WebCreateDataException{
		
		boolean isCreated = studentDatatableDPO.studentCreate(userCreateDTO);
		
		if (isCreated) {
			return true;
		} else {
			throw new WebCreateDataException("Unable to create: " + userCreateDTO.getName());
		}
		
	}

	// Update
	
	@Override
	public StudentUpdateVO updateResponse(int id) throws WebPageNotFoundException {

		Optional<StudentUpdateVO> optionalUserUpdateVO = studentDatatableDPO.getStudentForUpdate(id);

		if (optionalUserUpdateVO.isPresent()) {
			return optionalUserUpdateVO.get();
		} else {
			throw new WebPageNotFoundException();
		}
	}

	@Override
	public boolean updateRequest(StudentUpdateDTO userUpdateDTO, int id) throws WebUpdateDataException {
		boolean isUpdated = studentDatatableDPO.studentUpdate(userUpdateDTO, id);

		if (isUpdated) {
			return true;
		} else {
			throw new WebUpdateDataException("Unable to update: " + userUpdateDTO.getName());
		}
	}

}
