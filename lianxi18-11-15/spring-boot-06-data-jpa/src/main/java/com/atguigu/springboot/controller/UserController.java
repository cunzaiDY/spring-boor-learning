package com.atguigu.springboot.controller;

import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    //添加操作
    @GetMapping(value = "/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
