package com.blee.bleespring.service;

import com.blee.bleespring.controller.DTO.StudentDTO;
import com.blee.bleespring.entity.Student;
import com.blee.bleespring.repository.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Setter
@Getter
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> getStudentAll(){
        List<Student> result = studentRepository.findAll();
        List<StudentDTO> students = new ArrayList<>();

        for ( Student student: result ){
            // Builder : 객체를 만들 때 순서에 의해 생기는 문제,
            //           명시적이지 못한 문제 를 해결하기 위해 나온 방법
            // 생성자 주입 : 여러개의 필드가 있을 때 순서를 지켜줘야 한다.
            // setter : 필드 개수만큼 매번 메소드를 만들어줘야 한다.
            StudentDTO studentDTO = StudentDTO.builder() // new Builder
                    .nickname(student.getNickname())
                    .name(student.getName())
                    .build();
            students.add(studentDTO);
        }
        return students;
    }

    public String insertStudent(String name, String nickname, Student.LoginType type){
        // 받아온 데이터롤 repository 의 save 메소드를 호출
        Student student = Student.builder().name(name).nickname(nickname).build();
        Student newStudent = studentRepository.save(student);
        // newStudent: save 를 한 후 반환되는 Entity 객체
        return newStudent.getId() + newStudent.getName();
    }

    public String searchStudentByName(String name){
        Student student = studentRepository.findByName(name);
        // List<Student> student = ~ : 리스트를 사용할 시
        return "id는" + student.getId() + "입니다.";
        // student.size() : 리스트를 사용할 시 (get 을 바로 사용하지 못함)
    }
    
    public String searchStudentById(int id){
//        Optional<Student> student = studentRepository.findById(id);
//        if ( student.isPresent()){
//            // isPresent: 객체의 여부를 boolean 으로 반환
//            return student.get().getName();
//            // get: Optional 에 담긴 객체를 반환
//        }
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no user"));
        // orElse(): 있으면 반환하고 없으면 다른 값 반환
        // orElseThrow(): 있으면 반환하고 없으면 error 처리
        return student.getName();
//        return "null";
        
        // Optional<T> : null 일수도 있는 객체를 감싸는 wrapper 클래스
    }

    public Long countStudentByNickname(String nickname){
        return studentRepository.countByNickname(nickname);

    }

    public String updateStudentName(int id, String name) {
        // save(T): 새로운 entity 를 insert or 기존 entity 를 update
        // T의 기본값(pk)의 상태에 따라 다르게 동작
        // -pk 값이 존재하는 경우: pk 와 연결된 entity 를 update
        // -pk 값이 없는 경우: 개로운 entity 를 insert

//        Student student = studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("id is wrong"));
//
//
//        Student modifiedStudent = Student.builder().id(id).name(name).build();
//        StudentRepository.save(modifiedStudent);
//        return "update done";


        studentRepository.updateStudentName(id, name);
        return "id" + id + "의 이름을" + name + "으로 변경했음";
    }
}