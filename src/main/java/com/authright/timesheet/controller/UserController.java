package com.authright.timesheet.controller;

import com.authright.timesheet.model.User;
import com.authright.timesheet.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable(name = "userId") long userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/user/name/{userName}")
    public User findUserByName(@PathVariable(name = "userName") String userName){
        return userService.findUserByName(userName);
    }

    @GetMapping("/user/email/{email}")
    public User findUserByEmail(@PathVariable(name = "email") String email){
        return userService.findUserByEmail(email);
    }

    @GetMapping("/user/phone/{phone}")
    public User findUserByPhone(@PathVariable(name = "phone") String phone){
        return userService.findUserByPhone(phone);
    }

}
