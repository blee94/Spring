package com.blee.bleespring.controller.Control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Practice2Controller {

    @GetMapping("/practice2")
    public String getMain(){return "practice2";}
    @PostMapping("post/practice2")
    @ResponseBody
    public String postPractice2(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "gender", required = false) String b,
            @RequestParam(value = "birth", required = false) String c,
            @RequestParam(value = "interest", required = false) String d,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("gender", b);
        model.addAttribute("birth", c);
        model.addAttribute("interest", d);
        return "이름:" + a + "성별:" + b + "생년월일:" + c + "관심사:" + d;
    }
}
