package com.imyc.SBAP.Http.student.dao.repository;

import com.imyc.SBAP.Http.student.dao.Student;
import com.imyc.SBAP.Http.user.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StudentRepository
        extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    Optional<Student> findByName(String name);

    Optional<Student> findByRollNo(String rollNo);


}

