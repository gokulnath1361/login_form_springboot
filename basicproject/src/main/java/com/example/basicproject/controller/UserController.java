package com.example.basicproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicproject.dto.UserDto;
import com.example.basicproject.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserService userService;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("{userName}/{password}")
          public UserDto getUserDetails(@PathVariable String userName,@PathVariable String password) {
        	  return userService.getUserByUserNameAndPassword(userName,password);
          }
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("{userName}")
    public UserDto getUserDetails(@PathVariable String userName) {
  	  return userService.getUserDetails(userName);
    }
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/new")
	public String addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update")
	public String updateUser(@RequestBody UserDto userDto) {
		return userService.updateUser(userDto);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete/{userName}")
	public String deleteUser( @PathVariable String userName) {
		return userService.deleteUser(userName);
	}
}
