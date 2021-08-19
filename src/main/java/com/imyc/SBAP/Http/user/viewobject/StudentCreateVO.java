package com.imyc.SBAP.Http.user.viewobject;

import com.imyc.SBAP.Http.role.viewobject.RoleVO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain=true)
public class StudentCreateVO {
    private List<RoleVO> roleVOList;
}
