package com.example.Habit_Tracker_App.services;

import com.example.Habit_Tracker_App.models.User;
import com.example.Habit_Tracker_App.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService  {

    private final UserRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Saving person: " + user);

        peopleRepository.save(user);
    }


}
