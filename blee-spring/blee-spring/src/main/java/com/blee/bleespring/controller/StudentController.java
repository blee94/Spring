package com.blee.bleespring.controller;

import com.blee.bleespring.controller.DTO.StudentDTO;
import com.blee.bleespring.repository.StudentRepository;
import com.blee.bleespring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
//    @GetMapping("/count")
//    public int getCountAll(){}

    @GetMapping("/all")
    public int getAll(){
        // student 의 목록을 전부 가져와서 보여주는 api
        List<StudentDTO> result = studentService.getStudentAll();
        return result.size();
//        return studentService.getStudentAll();
    }

//    @GetMapping("/search")
//    public ? getSearch(@RequestBody int id){}
}