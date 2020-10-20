package com.authright.timesheet.controller;

import com.authright.timesheet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class RoleController {
    @Autowired
    RoleController roleController;

    @GetMapping("/role/{roleId}")
    public List<User> findUsers(@PathVariable(name = "roleId") long roleId){
        return roleController.findUsers(roleId);
    };
}
