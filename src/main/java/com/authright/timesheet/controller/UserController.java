package com.authright.timesheet.controller;

import com.authright.timesheet.model.*;
import com.authright.timesheet.service.FileService;
import com.authright.timesheet.service.FileServiceImpl;
import com.authright.timesheet.service.UserService;
import com.authright.timesheet.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
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
        return userService.update(user);
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

    @GetMapping("/user/myTimesheet/{userId}")
    public List<Timesheet> findMyTimesheets(@PathVariable(name = "userId") long userId) {
        return userService.findMyTimesheets(userId);
    }

    @GetMapping("/user/myTimesheet/{userId}/{startDate}/endDate")
    public List<Timesheet> findTimesheetsByDate(@PathVariable(name = "userId") long userId, @PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return userService.findTimesheetByDate(userId, startDate.toInstant().atOffset(ZoneOffset.UTC),  endDate.toInstant().atOffset(ZoneOffset.UTC));
    }


    @GetMapping("/user/manageGroups/{userId}")
    public List<Group> findMangeGroups(@PathVariable(name = "userId") long userId) {
        return userService.findManageGroups(userId);
    }

    @GetMapping("/user/joinGroups/{userId}")
    public List<Group> findJoinGroups(@PathVariable(name = "userId") long userId) {
        return userService.findJoinGroups(userId);
    }

    @GetMapping("/user/findRoles/{userId}")
    public List<Role> findRoles(@PathVariable(name = "userId") long userId) {
        return userService.findRoles(userId);
    }

    @GetMapping("/user/findContracts/{userId}")
    public List<Contract> findContracts(@PathVariable(name = "userId") long userId) {
        return userService.findContracts(userId);
    }


    @GetMapping("/user/avatar/{userId}")
    public URL getAvatar(@PathVariable(name = "userId") long userId){
        User user = userService.findUserById(userId);
        String s3Key =  user.getAvatarUrl();
        URL url=  fileService.getObjectUrl(s3Key);
        return url;
    }

    @PostMapping("/user/avatar")
    public User saveAvatar(@RequestBody User user,@RequestParam("file") MultipartFile file){
        String s3Key = fileService.putObject(file);
        user.setAvatarUrl(s3Key);
        return userService.save(user);
    }

}
