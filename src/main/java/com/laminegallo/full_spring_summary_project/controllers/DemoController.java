package com.laminegallo.full_spring_summary_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class DemoController {

    @GetMapping("/demo")
    public String demo(){

        return "Demo!";
    }

}
