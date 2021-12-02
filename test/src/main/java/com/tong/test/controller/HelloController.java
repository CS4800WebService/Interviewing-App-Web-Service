package com.tong.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String getHelloWorld() {
        return "I hate webapis!!!";
    }
    @RequestMapping("/option2")
    public String getMessage2() {
        return "yay different messages based on url";
    }
}
