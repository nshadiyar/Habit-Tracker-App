package com.example.Habit_Tracker_App.controllers;

import com.example.Habit_Tracker_App.models.User;
import com.example.Habit_Tracker_App.services.RegistrationService;
import com.example.Habit_Tracker_App.utils.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final UserValidator userValidator;

    public AuthController(RegistrationService registrationService, UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage(@ModelAttribute("user")User user){
        return "auth/register";
    }

    @PostMapping("/register")
    public String performRegister(@ModelAttribute("user") @Valid User user,
                                  BindingResult bindingResult){
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            System.out.println("Received user: " + user);
            return "/auth/register";
        }
        registrationService.register(user);
        System.out.println("User registered successfully!");

        return "redirect:/auth/login";
    }
}
