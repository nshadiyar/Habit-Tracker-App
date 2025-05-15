package com.example.Habit_Tracker_App.services;

import com.example.Habit_Tracker_App.models.User;
import com.example.Habit_Tracker_App.repositories.UserRepository;
import com.example.Habit_Tracker_App.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty())
            throw  new UsernameNotFoundException("user not found");

        return new UserPrincipal(user.get());
    }

}
