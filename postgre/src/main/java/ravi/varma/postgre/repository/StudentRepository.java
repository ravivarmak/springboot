package ravi.varma.postgre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ravi.varma.postgre.entity.StudentEntity;

public interface StudentRepository  extends JpaRepository<StudentEntity, Long> {

}
