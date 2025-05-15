package com.example.Habit_Tracker_App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
