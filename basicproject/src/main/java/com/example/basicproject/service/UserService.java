package com.example.basicproject.service;

import com.example.basicproject.dto.UserDto;
public interface UserService {
	public UserDto getUserDetails(String userName);
           public String addUser(UserDto userDto);
           public String updateUser(UserDto userDto);
           public String deleteUser(String userName);
           public UserDto getUserByUserNameAndPassword(String userName,String password);
           
}
