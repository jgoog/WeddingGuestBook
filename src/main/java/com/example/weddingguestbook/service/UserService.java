package com.example.weddingguestbook.service;


import com.example.weddingguestbook.exceptions.InformationExistException;
import com.example.weddingguestbook.exceptions.InformationNotFoundException;
import com.example.weddingguestbook.model.Request.LoginRequest;
import com.example.weddingguestbook.model.Response.LoginResponse;
import com.example.weddingguestbook.model.User;
import com.example.weddingguestbook.model.UserProfile;
import com.example.weddingguestbook.repository.UserProfileRepository;
import com.example.weddingguestbook.repository.UserRepository;
import com.example.weddingguestbook.security.JWTUtils;
import com.example.weddingguestbook.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository){this.userProfileRepository = userProfileRepository;}

    @Autowired
    public void setUserRepository(UserRepository userRepository) {this.userRepository = userRepository;}

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    public User createUser(User userObject){
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            //create new user and save it in the database
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new InformationExistException("user with email address " + userObject.getEmailAddress() + " already exists");
        }
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        final String JWT = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok((new LoginResponse(JWT)));
    }

//    public UserProfile createProfile(Long userId, UserProfile userObject){
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userRepository.findByIdAndUserId(userId,userDetails.getUser().getId());
//        if (user == null) {
//            throw new InformationNotFoundException(
//                    "user with id " + userId + " does not belongs to this user or user oes not exist");
//        }
////        UserProfile userProfile = userProfileRepository.findByLastNameAndUserId(userObject.getLastName(), userDetails.getUser().getId());
////        if (userProfile != null) {
////            throw new InformationExistException("profile with name " + userProfile.getLastName() + " already exists");
////        }
////        userObject.setUser(userDetails.getUser());
////        userObject.setUser(user);
//        return userProfileRepository.save(userObject);
//    }




    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }
}
