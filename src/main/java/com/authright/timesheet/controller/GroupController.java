package com.authright.timesheet.controller;


import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupServiceImpl groupService;


    @PostMapping("/group")
    public Group save(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping("/group")
    public Group update(@RequestBody Group group) {
        return groupService.update(group);
    }

    @GetMapping("/group/{groupId}")
    public Group findGroupById(@PathVariable(name = "groupId") long groupId) {
        return groupService.findGroupById(groupId);
    }

    @GetMapping("/group/name/{groupName}")
    public Group findGroupByName(@PathVariable(name = "groupName") String groupName) {
        return groupService.findGroupByName(groupName);
    }

    @GetMapping("/group/users/{groupId}}")
    public List<User> findUsers(@PathVariable(name = "groupId") long groupId) {
        return groupService.findUsers(groupId);
    }


}
