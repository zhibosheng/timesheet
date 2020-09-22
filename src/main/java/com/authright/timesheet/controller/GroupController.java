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

    @RequestMapping(value = "/group/{groupId}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Group getGroupById(@PathVariable(name = "groupId") long groupId){
        return groupService.getGroupById(groupId);
    }

}
