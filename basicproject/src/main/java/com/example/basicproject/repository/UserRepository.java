package com.example.basicproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.basicproject.entity.User;

public interface UserRepository extends CrudRepository<User,String> {
             User findByUserNameAndPassword(String userName,String password);
}
