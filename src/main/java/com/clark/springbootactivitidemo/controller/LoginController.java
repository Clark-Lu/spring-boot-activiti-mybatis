package com.clark.springbootactivitidemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller(value = "/")
public class LoginController {
    @RequestMapping(value = {"/login","/url1","url2"},method = RequestMethod.GET)
    public String login(@RequestParam String user ,@RequestParam String password){
        return "login";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String hello(String name){
        return "hello " + name;
    }

}


