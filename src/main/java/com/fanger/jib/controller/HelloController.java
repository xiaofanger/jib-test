package com.fanger.jib.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/send", method = {RequestMethod.GET})
    public String sendMsg() {
        return "this is test msg.";
    }



}
