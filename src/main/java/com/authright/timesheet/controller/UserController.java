package com.authright.timesheet.controller;

import com.authright.timesheet.model.*;
import com.authright.timesheet.service.FileService;
import com.authright.timesheet.service.FileServiceImpl;
import com.authright.timesheet.service.UserService;
import com.authright.timesheet.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        User tempUserInfo = userService.findUserById(user.getUserId());
        if(!user.getUserName().equals("")) {
            tempUserInfo.setUserName(user.getUserName());
        }
        if(!user.getFirstName().equals("")) {
            tempUserInfo.setFirstName(user.getFirstName());
        }
        if(!user.getLastName().equals("")) {
            tempUserInfo.setLastName(user.getLastName());
        }
        if(!user.getEmail().equals("")) {
            tempUserInfo.setEmail(user.getEmail());
        }
        if(!user.getPhone().equals("")) {
            tempUserInfo.setPhone(user.getPhone());
        }
//        if(!user.getAvatarUrl().equals("")) {
//            tempUserInfo.setAvatarUrl(user.getAvatarUrl());
//        }
        return userService.update(tempUserInfo);
    }

    @GetMapping("/user/{userId}")
    public User findUserById(@PathVariable(name = "userId") long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/user/name/{userName}")
    public User findUserByName(@PathVariable(name = "userName") String userName) {
        return userService.findUserByName(userName);
    }

    @GetMapping("/user/email/{email}")
    public User findUserByEmail(@PathVariable(name = "email") String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("/user/phone/{phone}")
    public User findUserByPhone(@PathVariable(name = "phone") String phone) {
        return userService.findUserByPhone(phone);
    }

    @GetMapping("/user/changePassword/{userId}/{oldPassword}/{newPassword}")
    public User changePassword(@PathVariable(name = "userId") long userId, @PathVariable(name = "oldPassword") String oldPassword, @PathVariable(name = "newPassword") String newPassword) {
        return userService.changePassword(userId, oldPassword, newPassword);
    }

    @GetMapping("/user/myTimesheet/{userId}")
    public List<Timesheet> findMyTimesheets(@PathVariable(name = "userId") long userId) {
        return userService.findMyTimesheets(userId);
    }

    @GetMapping("/user/myTimesheet/{userId}/{startDate}/{endDate}")
    public List<Timesheet> findTimesheetsByDate(@PathVariable(name = "userId") long userId, @PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return userService.findTimesheetByDate(userId, startDate.toInstant().atOffset(ZoneOffset.UTC),  endDate.toInstant().atOffset(ZoneOffset.UTC));
    }



    @GetMapping("/user/manageGroups/{userId}")
    public List<Group> findManageGroups(@PathVariable(name = "userId") long userId) {
        return userService.findManageGroups(userId);
    }

    @GetMapping("/user/joinGroups/{userId}")
    public List<Group> findJoinGroups(@PathVariable(name = "userId") long userId) {
        return userService.findJoinGroups(userId);
    }

    @GetMapping("/user/roles/{userId}")
    public List<Role> findRoles(@PathVariable(name = "userId") long userId) {
        return userService.findRoles(userId);
    }

    @GetMapping("/user/manageContracts/{userId}")
    public List<Contract> findManageContracts(@PathVariable(name = "userId") long userId) {
        return userService.findManageContracts(userId);
    }


    @GetMapping("/user/contracts/{userId}")
    public List<Contract> findContracts(@PathVariable(name = "userId") long userId) {
        return userService.findContracts(userId);
    }


    @GetMapping("/user/avatar/{userId}")
    public HashMap getAvatar(@PathVariable(name = "userId") long userId){
        HashMap avatarUrl = new HashMap();
        User user = userService.findUserById(userId);
        String s3Key =  user.getAvatarUrl();
        URL url=  fileService.getObjectUrl(s3Key);
        avatarUrl.put("url",url);
        return avatarUrl;
    }

    @PostMapping("/user/avatar/{userId}")
    public User saveAvatar(@PathVariable(name = "userId") long userId,@RequestBody MultipartFile file){
        User user = userService.findUserById(userId);
        String s3Key = fileService.putObject(file);
        user.setAvatarUrl(s3Key);
        return userService.save(user);
    }

    @GetMapping("/user/allUsers")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

}
