package com.blee.bleespring.controller.apiFree.vo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Controller

public class PracticeVOController {
    @GetMapping("/PracticeVO")
    public String getMain(){ return "practice2"; }

    @PostMapping("/axios/vo/practiceVO")
    @ResponseBody
    public String axiosVoPractice(@ModelAttribute PracticeVO practiceVO){
        return "이름: " +practiceVO.getName() + "성별: " + practiceVO.getGender() + "생년월일: " + practiceVO.getBirth() + "관심사: " + practiceVO.getInterest();


    }

    // 일반폼전송의 데이터는 본문? url? -> url
    // url을 객체로 볼 수 있는 친구는 requestbody? modelattribute? -> modelattribute
}
