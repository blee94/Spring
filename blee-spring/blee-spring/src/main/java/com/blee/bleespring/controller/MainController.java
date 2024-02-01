package com.blee.bleespring.controller;

import com.blee.bleespring.controller.DTO.UserDTO;
import com.blee.bleespring.controller.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// @RestController // @controller + @responsebody
@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(){ return "request"; }

    @GetMapping("/get/response1")
    // ?key=value
    // ?name=
    // @RequestParam 는 기본값으로 required=true
    public String getResponse1(
            @RequestParam(value = "name") String i,
            Model model){
        model.addAttribute("name", i);
        return "response";
    }
    @GetMapping("/get/response2")
    public String getResponse2(
            @RequestParam(value="name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response3/{param1}/{param2}")
    public String getResponse3(@PathVariable String param1,
                               @PathVariable(value = "param2") String age, Model model){
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "response";
    }

    @GetMapping({"/get/response4/{param1}", "/get/response4/{param1}/{param2}"})
//    선택적으로 둘 params 를 뺀 url 도 작성해야함.
    public String getResponse4(@PathVariable String param1,
                               @PathVariable(required = false, value = "param2") String age, Model model){
//        선택적으로 둘 param 만 required = false 를 줬음.
        model.addAttribute("name", param1);
        model.addAttribute("age", age);
        return "response";


    }
    @PostMapping("post/response1")
    public String postResponse1(
            @RequestParam(value = "name") String a,
            @RequestParam(value = "age") String b,

            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return "response";
    }
//   request 에 "name" 밖에 없기 때문에 age 가 포함되면 에러가 난다. 아래와 같이 required = false 를 추가해 null 값을 표시하게 한다.
    @PostMapping("post/response2")
    public String postResponse2(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "age", required = false) String b,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return "response";
    }

//   @ResponseBody
//    응답 시 객체를 json 형태로 리턴한다. (직렬화)
//    express res.send 와 비슷

    @PostMapping("post/response3")
    @ResponseBody
    public String postResponse3(
            @RequestParam(value = "name", required = false) String a,
            @RequestParam(value = "age", required = false) String b,
            Model model
    ){
        model.addAttribute("name", a);
        model.addAttribute("age", b);
        return "hello" + a;
    }

    @GetMapping("/dto/response1")
    @ResponseBody public String dtoResponse1(UserDTO userDTO){
        // DTO: Getter 와 Setter 가 있는 객체
        // ModelAttribute: HTML 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑.
        // 매핑 = setter 함수 실행
        // ?name=홍길동&age=10 -> setName("홍길동") setAge("10")
        return userDTO.getName() + " " + userDTO.getAge();
    }

    // @RequestBody: 요청의 본문에 있는 데이터(body)를 받음.
    @GetMapping("/dto/response2")
    @ResponseBody
    public String dtoResponse11(@RequestBody UserDTO userDTO){
        return userDTO.getName() + " " + userDTO.getAge();
    }

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(UserVO userVO) {
        return userVO.getName() + " " + userVO.getAge();
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVO userVO){
        return userVO.getName() + " " + userVO.getAge();
    }

    @PostMapping("/vo/response3")
    @ResponseBody
    public String voResponse3(@RequestBody UserVO userVO){
        return userVO.getName() + " " + userVO.getAge();
    }

    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosResponse1(@RequestParam String name, @RequestParam String age){
         return name + " " + age;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosResponse2(UserDTO userDTO){
        return userDTO.getName() + " " + userDTO.getAge();
    }
    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosRes3(@RequestParam String name, @RequestParam String age){
        return "이름: " + name + ", 나이: "+ age;
    }
    // url 이었는데, axios post 는 url 에 데이터가 x

    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosRes4(UserDTO userDTO){
        return "이름:" + userDTO.getName() + ", 나이: "+ userDTO.getAge();
    }
    // ModelAttribute 를 이용해 데이터를 보냈을 때 값이 null
    // axios 로 보내면 url 로 데이터를 보내는 게 아니라 본문으로 데이를 보낸다.
    // 즉, ModelAttribute 가 값을 볼 수 없다.
    // axios + post 데이터 -> @ModelAttribute O(null)

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosRes5(@RequestBody UserDTO userDTO){
        return "이름:" + userDTO.getName() + ", 나이: "+ userDTO.getAge();
    }
    // axios + post 데이터 -> @RequestBody O


    // ========== VO 이용 with. axios ==========
    @GetMapping("/axios/vo/response1")
    @ResponseBody
    public String axiosVoRes1(@RequestParam String name, @RequestParam String age) {
        return "이름: " + name + ", 나이: " + age;
    }

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosVoRes2(UserVO userVO) {
        return "이름: "+ userVO.getName() + ", 나이: "+ userVO.getAge();
    }

    @PostMapping("/axios/vo/response3")
    @ResponseBody
    public String axiosVoRes3(@RequestParam String name, @RequestParam String age) {
        return "이름: " + name + ", 나이: " + age;
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosVoRes4(UserVO userVO){
        return "이름: "+ userVO.getName() + ", 나이: "+ userVO.getAge();
    }

    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosVoRes5(@RequestBody UserVO userVO){
        return "이름: "+ userVO.getName() + ", 나이: "+ userVO.getAge();
    }
    // @RequestBody 는 setter || 메소드의 유무와 관계없이 변수에 값을 넣을 수 있다.
}
