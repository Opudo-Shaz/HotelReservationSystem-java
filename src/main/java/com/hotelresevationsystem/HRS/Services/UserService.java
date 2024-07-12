package com.hotelresevationsystem.HRS.Services;

import com.hotelresevationsystem.HRS.Entity.User;
import com.hotelresevationsystem.HRS.Repository_Interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.getPassword().equals(password);
        }

        return false; // User with email not found
    }

    public User register(User user) {
        // Check if the user already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }
}
