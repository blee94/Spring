package com.blee.bleespring.controller.api;

import com.blee.bleespring.controller.DTO.UserDTO;
import com.blee.bleespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user") //
public class UserController {
//    C, R 할꺼임
//    1. Table 생성
//    2. domain 만들기
//    3. mapper 만들기
//    4. service 만들기
//    5. controller 만들기

    @Autowired
    UserService userService;

    @GetMapping("/all") // @RequestMapping 을 해줬기 때문에 기본 경로가 "/all" 이 아닌 "/user/all" 이 된다.
    public List<UserDTO> getUser(){
        List<UserDTO> result = userService.retrieveAll();
        return result;
    }

    @GetMapping("/user") // 기본 경로 설정
    public String getUserInsert(@RequestParam String name, @RequestParam String nickname){
    userService.createUser(name, nickname);
    return "Success";
    }

    @GetMapping("/practice1")
    public String getUserPractice1(@RequestParam String id, @RequestParam String nickname){
        userService.createUser(id, nickname);
        return "ok";
    }

    @GetMapping("/practice1/update")
    public String updateUserPractice1(@RequestParam String id, @RequestParam String nickname){
        userService.updateUser(id, nickname);
        return "done";
    }

    @GetMapping("/practice1/delete")
    public String deleteUserPractice1(@RequestParam String id){
        userService.deleteUser(id);
        return "success";
    }

}
