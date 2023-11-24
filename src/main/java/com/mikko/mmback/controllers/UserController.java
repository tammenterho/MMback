package com.mikko.mmback.controllers;

import com.mikko.mmback.entities.User;
import com.mikko.mmback.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserRepository URepo;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User>users = URepo.findAll();
        return users;
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User>deleteUser(@PathVariable ("id") Long id) {
        System.out.println("deleting");
        try {
            URepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
