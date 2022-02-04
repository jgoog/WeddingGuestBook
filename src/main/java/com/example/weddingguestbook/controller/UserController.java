package com.example.weddingguestbook.controller;


import com.example.weddingguestbook.model.Request.LoginRequest;
import com.example.weddingguestbook.model.User;
import com.example.weddingguestbook.model.UserProfile;
import com.example.weddingguestbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth/users")
public class UserController {

    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @PostMapping("/register/")
    public User createUser(@RequestBody User userObject){return userService.createUser(userObject);}

    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){ //returns login to user
        return userService.loginUser(loginRequest);
    }

//    @PostMapping(path = "/user/{userId}/profile/")
//    public UserProfile createProfile(@PathVariable(value = "userId")Long userId, @RequestBody UserProfile userProfileObject){
//        return userService.createProfile(userId, userProfileObject);
//    }






}
