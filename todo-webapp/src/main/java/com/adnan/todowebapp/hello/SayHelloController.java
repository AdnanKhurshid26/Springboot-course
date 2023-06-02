package com.adnan.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SayHelloController {
    static int counter = 0;
    @RequestMapping("/")
    public String sayHello() {
        counter++;
        System.out.println("counter: " + counter);
        return "sayHello";
    }
}
