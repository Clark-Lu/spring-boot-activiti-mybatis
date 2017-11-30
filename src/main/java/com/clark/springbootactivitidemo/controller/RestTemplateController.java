package com.clark.springbootactivitidemo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/*")
public class RestTemplateController {

    @GetMapping("/rest")
    @ResponseBody
    public String RestTemplateUse(){
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> variable = new LinkedMultiValueMap<>();
        variable.set("name","Clark_Lu");
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(variable,headers);
        return template.postForEntity("http://localhost:8080/hello",entity,String.class).toString();
    }

}
