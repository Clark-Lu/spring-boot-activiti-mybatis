package com.clark.springbootactivitidemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "/")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam String user ,@RequestParam String password){
        return "login";
    }
}
