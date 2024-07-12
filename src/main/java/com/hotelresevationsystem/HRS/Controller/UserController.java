package com.hotelresevationsystem.HRS.Controller;

import com.hotelresevationsystem.HRS.Entity.User;
import com.hotelresevationsystem.HRS.Repository_Interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        // Find the user by email
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Check if the passwords match
            if (user.getPassword().equals(password)) {
                // Add user information to the model
                model.addAttribute("user", user);
                // Redirect to index.html
                return "index";
            }
        }
        // If login fails, add an error message to the model and return to login page
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }



    @PostMapping("/user/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String confirmPassword,
                         Model model)
    {
        // Validate passwords match
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "signup";
        }

        // Check if the email is already registered
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            model.addAttribute("error", "Email already exists");
            return "signup";
        }
        // Create a new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);

        // Save the user to the database
        userRepository.save(newUser);

        // success message and redirect to login page
        model.addAttribute("success", "User registered successfully");
        return "login";
    }
}


