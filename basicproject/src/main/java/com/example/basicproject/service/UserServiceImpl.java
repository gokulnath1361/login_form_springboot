package com.example.basicproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicproject.dto.UserDto;
import com.example.basicproject.entity.User;
import com.example.basicproject.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service("userService")
public class UserServiceImpl implements UserService {
	    @Autowired
           UserRepository userRepository;

		@Override
		public UserDto getUserDetails(String userName) {
			Optional<User> user=userRepository.findById(userName);
			User userEntity=user.get();
		UserDto userDto =new UserDto();
		userDto.setUserName(userEntity.getUserName());
		userDto.setPassword(userEntity.getPassword());

			
			return userDto;
		}


       @Transactional
		@Override
		public String addUser(UserDto userDto) {
			User user = new User();
			user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
			userRepository.save(user);
			return "sucess";
	}
        @Transactional
		@Override
		public String updateUser(UserDto userDto) {
			Optional<User> optionalUser=userRepository.findById(userDto.getUserName());
			User user = optionalUser.get();
			user.setUserName(userDto.getUserName());
			user.setPassword(userDto.getPassword());
			return "Success";
		}
		
		@Override
		public String deleteUser(String userName) {
			userRepository.deleteById(userName);
			return "success";
		}

		@Override
		public UserDto getUserByUserNameAndPassword(String userName, String password) {
			User userEntity=userRepository.findByUserNameAndPassword(userName, password);
			UserDto userDto=new UserDto();
			userDto.setUserName(userEntity.getUserName());
			userDto.setPassword(userEntity.getPassword());
			
			return userDto;
		}
}
