package com.example.Habit_Tracker_App.utils;

import com.example.Habit_Tracker_App.models.User;
import com.example.Habit_Tracker_App.services.MyUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final MyUserDetailsService myUserDetailsService;

    public UserValidator(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            myUserDetailsService.loadUserByUsername(user.getUsername());
        }
        catch (UsernameNotFoundException ignore){
            return;
        }
        errors.rejectValue("username", " ", "User with this username already exist");
    }
}
