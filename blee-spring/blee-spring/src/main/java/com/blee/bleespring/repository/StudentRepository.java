package com.blee.bleespring.repository;

import com.blee.bleespring.entity.Student;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository<대상으로 지정 할 엔티티, 해당 엔티티의 pk 타입>
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 1. jpa 의 기본 규칙을 따르는 방법---------------------------
        // findBy 컬럼명
    Student findByName(String name);
        // nickname 으로 하고 싶으면 <Student findByNickname(String Nickname);> 하면 됌
        // 중복된 결과가 있을수도 있으니 List 에 담는게 좋음
        // -> List<Student> findByName(String name);
    
    // Student findByNameAndNickname(String name, String nickname) : name 과 nickname 이 일치할 때 가져오는거
        // Or 도 사용가능.


    // 2. 직접 쿼리를 작성해서 연결--------------------------------
//    @Query("select s from Student s where s.name = :name")
    // 헷갈리면 아래처럼 nativeQuery로 작성하면 됌
    @Query(nativeQuery = true, value= "select * from student where name = :a")
    // name = :a -> parameter. 이름으로 찾는거임.
    List<Student> findTest(String a);


    @Query(nativeQuery = true, value = "select count(*) from student where nickname = :a")
    Long countByNickname(String a);

//    @Query(nativeQuery = true, value = "select * from student where id = :id")
//    List<Student> updateStudentName(int id, String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE student SET name = :name WHERE id = :id")
    void updateStudentName(@Param("id") int id, @Param("name") String name);

}
