package com.blee.bleespring.controller;

import com.blee.bleespring.controller.DTO.StudentDTO;
import com.blee.bleespring.entity.Student;
import com.blee.bleespring.repository.StudentRepository;
import com.blee.bleespring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
//    @GetMapping("/count")
//    public int getCountAll(){}

    // 1. 전체 검색 (select * from student)
    // 2. 삽입 (insert into ~)
    // 3. 조건에 따른 검색 (select * from student where name='')
    // 4. 조건에 따른 검색(2) (select * from student where id = )

//    -------1. 전체 검색 -------------
    @GetMapping("/all")
    public List<StudentDTO> getAll(){
        // student 의 목록을 전부 가져와서 보여주는 api
        List<StudentDTO> result = studentService.getStudentAll();
        return result;
//        return studentService.getStudentAll();
    }
//    ----------2. 삽입----------------

    @GetMapping("/insert") // /student/insert?name=이름
    public String insertStudent(@RequestParam String name,
                                @RequestParam String nickname,
                                @RequestParam Student.LoginType type){
        studentService.insertStudent(name, nickname, type);
        // 이름, 닉네임, type
        return studentService.insertStudent(name,nickname,type);
    }

    @GetMapping("/search/name")
    public String searchStudentByName(@RequestParam String name){

        return studentService.searchStudentByName(name);
    }

    @GetMapping("/search/id")
    public String searchStudentById(@RequestParam int id){
        return studentService.searchStudentById(id);
    }

    @GetMapping("/search/nickname")
    public Long countStudentByNickname(@RequestParam String nickname){
        return studentService.countStudentByNickname(nickname);
    }

    @GetMapping("/update/{id}/name")
    public String updateStudentName(@PathVariable int id, @RequestParam String name){
        return studentService.updateStudentName(id, name);
    }


}