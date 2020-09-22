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

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable(name = "userId") long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/user/name/{userName}")
    public User getUserByName(@PathVariable(name = "userName") String userName){
        return userService.getUserByName(userName);
    }

    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable(name = "email") String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/phone/{phone}")
    public User getUserByPhone(@PathVariable(name = "phone") String phone){
        return userService.getUserByPhone(phone);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
}
