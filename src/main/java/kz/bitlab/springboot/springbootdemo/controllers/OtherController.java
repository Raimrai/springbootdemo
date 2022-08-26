package kz.bitlab.springboot.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }
}
