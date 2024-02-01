package com.blee.bleespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PracticeController {
    @GetMapping("/introduce")
    public String getMain(){ return "practice"; }

    @GetMapping("/get/introduce2/name={param1}&/age={param2}")
    @ResponseBody
   public String getIntroduce2(@PathVariable String param1,
                               @PathVariable(value = "param2") String age, Model model){
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "practice";
    }


}
