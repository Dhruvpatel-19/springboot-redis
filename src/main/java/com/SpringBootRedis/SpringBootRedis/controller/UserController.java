package com.SpringBootRedis.SpringBootRedis.controller;

import com.SpringBootRedis.SpringBootRedis.model.User;
import com.SpringBootRedis.SpringBootRedis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        boolean result = userService.saveUser(user);
        if(result)
            return ResponseEntity.ok("User created successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUsers(){
        List<User> users;
        users = userService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id")Long id){
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id")Long id){
        boolean result = userService.deleteUser(id);
        if(result)
            return ResponseEntity.ok("User deleted successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUserById(@RequestBody User user, @PathVariable("id")Long id){
        User updatedUser = userService.fetchUserById(id);

        if(updatedUser == null){
            return ResponseEntity.ok("User with given id doesn't exist");
        }

        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmailId(user.getEmailId());
        updatedUser.setAge(user.getAge());

        boolean result = userService.saveUser(updatedUser);

        if(result)
            return ResponseEntity.ok("User updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
