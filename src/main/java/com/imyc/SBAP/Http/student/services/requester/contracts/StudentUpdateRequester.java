package com.imyc.SBAP.Http.student.services.requester.contracts;

import com.imyc.SBAP.Base.services.CRUDContracts.UpdateContract;
import com.imyc.SBAP.Http.student.dto.StudentUpdateDTO;
import com.imyc.SBAP.Http.student.viewobject.StudentUpdateVO;
import com.imyc.SBAP.Http.user.dto.UserUpdateDTO;
import com.imyc.SBAP.Http.user.viewobject.UserUpdateVO;

public interface StudentUpdateRequester extends UpdateContract<StudentUpdateVO, StudentUpdateDTO> {

}
