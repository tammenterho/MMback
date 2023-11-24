package com.mikko.mmback.controllers;

import com.mikko.mmback.configs.UserAuthenticationProvider;
import com.mikko.mmback.dtos.CredentialsDto;
import com.mikko.mmback.dtos.SignUpDto;
import com.mikko.mmback.dtos.UserDto;
import com.mikko.mmback.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@CrossOrigin(origins = "https://marketing-scheduler-front-5e784db552ef.herokuapp.com", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @CrossOrigin(origins = "https://marketing-scheduler-front-5e784db552ef.herokuapp.com/", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @CrossOrigin(origins = "https://marketing-scheduler-front-5e784db552ef.herokuapp.com/", allowedHeaders = "*")
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        System.out.println("/register klikattu ja");
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}