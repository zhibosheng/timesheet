package com.authright.timesheet.controller;

import com.authright.timesheet.model.User;
import com.authright.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserById(@PathVariable(name = "userId") long userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/user/name/{userName}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByName(@PathVariable(name = "userName") String userName){
        return userService.getUserByName(userName);
    }

    @RequestMapping(value = "/user/email/{email}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByEmail(@PathVariable(name = "email") String email){
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/user/phone/{phone}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByPhone(@PathVariable(name = "phone") String phone){
        return userService.getUserByPhone(phone);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User update(@RequestBody User user){
        return userService.update(user);
    }
}
