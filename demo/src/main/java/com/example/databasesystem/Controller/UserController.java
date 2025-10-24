package com.example.databasesystem.Controller;


import com.example.databasesystem.model.User;
import com.example.databasesystem.service.JwtService;
import com.example.databasesystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private UserService service;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user){
        return  service.saveUser(user);
    }

    @PostMapping("/login")
    public  String login(@Valid@RequestBody User user){


        Authentication authentication =authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getEmail());
        else
            return "login failed";
    }


}