package com.authright.timesheet.controller;


import com.authright.timesheet.model.Group;
import com.authright.timesheet.service.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {
    @Autowired
    private GroupServiceImpl groupService;

    @GetMapping("/group/{groupId}")
    public Group getGroupById(@PathVariable(name = "groupId") long groupId){
        return groupService.getGroupById(groupId);
    }

}
