package com.bookmycab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookmycab.model.User;
import com.bookmycab.service.UserService;

// TODO: Completely remove User Controller

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User saveUserHandler(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping()
    public List<User> getAllUserHandler() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserHandler(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserHandler(@PathVariable("id") Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserHandler(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted with id!" + id, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLoginHandler(@RequestParam("username") String username, @RequestParam("password") String password) {
        User curUser = userService.getUserByUsername(username);
        if (curUser.getPassword().equals(password))
            return new ResponseEntity<>("Login success!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Password not matched!", HttpStatus.UNAUTHORIZED);
    }

}
