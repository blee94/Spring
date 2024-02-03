package com.blee.bleespring.controller.Control;

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

        peopleList.add(new Person("짱구", 9));
        peopleList.add(new Person("짱아", 3));
        peopleList.add(new Person("유리", 9));
        peopleList.add(new Person("맹구", 9));

        model.addAttribute("people", peopleList);

        return "people";
    }
}

