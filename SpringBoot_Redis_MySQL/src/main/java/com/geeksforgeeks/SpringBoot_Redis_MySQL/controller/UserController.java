package com.geeksforgeeks.SpringBoot_Redis_MySQL.controller;

import java.util.Optional;

import com.geeksforgeeks.SpringBoot_Redis_MySQL.entity.User;
import com.geeksforgeeks.SpringBoot_Redis_MySQL.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    public UserRepo userRepo;

    @RequestMapping("/load")
    public String load() {

        User aditya = new User(1, "Aditya", 10000);
        User john = new User(2, "John", 12000);
        User david = new User(3, "David", 5000);

        userRepo.save(aditya);
        userRepo.save(john);
        userRepo.save(david);
        return "Repo Count:"+userRepo.count();
    }

    @RequestMapping("/test")
    public String test() {return "Test Works";}

    @RequestMapping("/get/{userId}")
    @Cacheable(value = "jbdl-61-users", key="#userId")
    public Optional<User> getUser(@PathVariable int userId){
        return userRepo.findById(userId);
    }


    @RequestMapping("/delete/{userId}")
    @CacheEvict(value = "jbdl-61-users",key="#userId")
    public String deleteUser(@PathVariable int userId){
        userRepo.deleteById(Integer.valueOf(userId));
        return "Success";
    }
}
