package com.blee.bleespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //해당 클래스가 컨트롤러임을 할당하는 명령

public class HelloController {

    @GetMapping("/hi")
    // URL을 매핑시켜줌
    // 클라이언트가 /hi 경로로 Get method로 접근한다면 아래 메소드를 실행시킴
    public String getHi(Model model) {
        // Model: Controller 안의 메서드가 파라미터로 받을 수 있는 객체 중 하나
        // Model 안에 정보를 담아서 view로 전달
        // IoC: 개발자가 직접 model을 생성하지 않음.

        model.addAttribute("name", "홍길동");
        model.addAttribute("key","새싹");
        model.addAttribute("age","10");

        String [] x = {"a", "b", "c", "d", "e"};
        model.addAttribute("item1", x);
        char[] alphabetArray = new char[26];
        char alphabet = 'A';

        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = alphabet;
            alphabet++;
        }
        model.addAttribute("item2", alphabetArray);


        return "hi"; // hi 라는 템플릿 파일을 불러오는거임. res.render("hi")랑 같은거.

    }
}
