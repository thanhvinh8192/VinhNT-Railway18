package com.vti.ntv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping(value ={"api/test"})
public class TestController {

    @GetMapping
    public String testAPI(){
        return "Demo API";
    }
}
