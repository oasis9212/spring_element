package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
