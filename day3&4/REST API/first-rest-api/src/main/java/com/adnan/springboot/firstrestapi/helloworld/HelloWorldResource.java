package com.adnan.springboot.firstrestapi.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
    @GetMapping("/hello-world-path-param/{name}")
    public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
        return new HelloWorldBean("Hello World, " + name);
    }
    
}
