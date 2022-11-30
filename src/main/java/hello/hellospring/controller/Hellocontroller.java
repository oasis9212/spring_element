package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data","Hello!@");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hello_mvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-templete";
    }
    //api 방식의 spring
    @GetMapping("hello-string")
    @ResponseBody // http 문자로 넣거나 객체로 넣어서 처리한다. (객체일 경우 JSON 으로 ) 처리.
    // MappingJacksonHttpMessageConverter 으로 기본적으로 처리
    public String hello_string(@RequestParam(value = "name") String name){
        return "hello  "+name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello hello_api(@RequestParam(value = "name") String name){

        Hello hi =new Hello();
        hi.setName(name);
        return hi;

    }
    // java bean 규약  프로퍼티 방식.
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
