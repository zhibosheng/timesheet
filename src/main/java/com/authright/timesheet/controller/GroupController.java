package com.authright.timesheet.controller;


import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.GroupServiceImpl;
import com.authright.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class GroupController {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupServiceImpl groupService;


    @PostMapping("/group")
    public Group save(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping("/group")
    public Group update(@RequestBody Group group) {
        Group tempGroupInfo = groupService.findGroupById(group.getGroupId());
        if(!group.getGroupName().equals("")){
            tempGroupInfo.setGroupName(group.getGroupName());
        }
        if(!group.getGroupDescription().equals("")){
            tempGroupInfo.setGroupDescription(group.getGroupDescription());
        }
        return groupService.update(tempGroupInfo);
    }

    @GetMapping("/group/{groupId}")
    public Group findGroupById(@PathVariable(name = "groupId") long groupId) {
        return groupService.findGroupById(groupId);
    }

    @GetMapping("/group/name/{groupName}")
    public Group findGroupByName(@PathVariable(name = "groupName") String groupName) {
        return groupService.findGroupByName(groupName);
    }

    @GetMapping("/group/users/{groupId}")
    public List<User> findUsers(@PathVariable(name = "groupId") long groupId) {
        return groupService.findUsers(groupId);
    }

    @PostMapping("/group/addUser/{groupId}/{userId}")
    public List<User> addUser(@PathVariable(name = "groupId") long groupId, @PathVariable(name = "userId") long userId){
        User user = userService.findUserById(userId);
        Group group = groupService.findGroupById(groupId);
        groupService.addUser(group, user);
        return groupService.findUsers(groupId);
    }

    @PostMapping("/group/addUserByName/{groupId}/{userName}")
    public List<User> addUserByName(@PathVariable(name = "groupId") long groupId, @PathVariable(name = "userName") String userName){
        User user = userService.findUserByName(userName);
        Group group = groupService.findGroupById(groupId);
        groupService.addUser(group, user);
        return groupService.findUsers(groupId);
    }

    @PostMapping("/group/deleteUser/{groupId}/{userId}")
    public List<User> deleteUser(@PathVariable(name = "groupId") long groupId, @PathVariable(name = "userId") long userId){
        User user = userService.findUserById(userId);
        Group group = groupService.findGroupById(groupId);
        groupService.deleteUser(group, user);
        return groupService.findUsers(groupId);
    }

    @GetMapping("/group/allGroups")
    public List<Group> findAllGroups(){
        return groupService.findAllGroups();
    };
}
