package com.blee.bleespring.repository;

import com.blee.bleespring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository<대상으로 지정 할 엔티티, 해당 엔티티의 pk 타입>
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
