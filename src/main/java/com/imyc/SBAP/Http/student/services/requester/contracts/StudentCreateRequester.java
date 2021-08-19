package com.imyc.SBAP.Http.student.services.requester.contracts;

import com.imyc.SBAP.Base.services.CRUDContracts.CreateContract;
import com.imyc.SBAP.Http.student.dto.StudentCreateDTO;
import com.imyc.SBAP.Http.user.dto.UserCreateDTO;
import com.imyc.SBAP.Http.user.viewobject.StudentCreateVO;
import com.imyc.SBAP.Http.user.viewobject.UserCreateVO;

public interface StudentCreateRequester extends CreateContract<StudentCreateVO, StudentCreateDTO> {
	
}
