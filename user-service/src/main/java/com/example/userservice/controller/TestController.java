package com.example.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzz
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String helloWorld(){
        return "helloWorld";
    }
}
