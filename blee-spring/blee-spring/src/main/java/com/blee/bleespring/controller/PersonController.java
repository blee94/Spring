package com.blee.bleespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/people")
    public String getPeople(Model model) {
        List<Person> peopleList = new ArrayList<>();

        // 각기 다른 정보를 갖고 있는 Person 객체를 최소 4개 생성하여 ArrayList에 추가
        peopleList.add(new Person("짱구", 9));
        peopleList.add(new Person("짱아", 3));
        peopleList.add(new Person("유리", 9));
        peopleList.add(new Person("맹구", 9));

        model.addAttribute("people", peopleList);

        return "people";
    }
}

