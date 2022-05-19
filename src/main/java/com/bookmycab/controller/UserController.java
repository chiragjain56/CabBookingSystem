package com.bookmycab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmycab.model.User;
import com.bookmycab.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public User saveUserHandler(@RequestBody User user){
		return userService.saveUser(user);
	}

	@GetMapping()
	public List<User> getAllUserHandler(){
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public User getUserHandler(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
}
