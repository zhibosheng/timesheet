package com.authright.timesheet.controller;


import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.TimesheetService;
import com.authright.timesheet.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class TimesheetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimesheetService timesheetService;

    @PostMapping("/timesheet")
    public Timesheet save(@RequestBody Timesheet timesheet) {
        return timesheetService.save(timesheet);
    }

    @PutMapping("/timesheet")
    public Timesheet update(@RequestBody Timesheet timesheet) {
        return timesheetService.update(timesheet);
    }

    @GetMapping("/timesheet/{timesheetId}")
    public Timesheet findTimesheetById(@PathVariable(name = "timesheetId") long timesheetId) {
        return timesheetService.findTimesheetById(timesheetId);
    }

    @GetMapping("/timesheet/{startDate}/{endDate}")
    public List<Timesheet> findTimesheetByDate(@PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return timesheetService.findTimesheetByDate(startDate.toInstant().atOffset(ZoneOffset.UTC),endDate.toInstant().atOffset(ZoneOffset.UTC));
    }

    @GetMapping("/timesheet/users")
    public List<Timesheet> findTimesheetByUsersAndDate(@RequestParam List<String> userNameList, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")  Date startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date endDate) {
        List<Long> userIdList = new ArrayList<>();
        for(String userName: userNameList){
            User user = userService.findUserByName(userName);
            userIdList.add(user.getUserId());
        }
        return timesheetService.findTimesheetByUsersAndDate(userIdList,startDate.toInstant().atOffset(ZoneOffset.UTC),endDate.toInstant().atOffset(ZoneOffset.UTC));

    }

    @GetMapping("/timesheet/sendEmail")
    public List<Timesheet> sendTimesheetEmail(@RequestParam List<String> userNameList, @RequestParam String email, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date startDate, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date endDate) {
        List<Long> userIdList = new ArrayList<>();
        for(String userName: userNameList){
            User user = userService.findUserByName(userName);
            userIdList.add(user.getUserId());
        }
        return timesheetService.sendTimesheetEmail(userIdList,email, startDate.toInstant().atOffset(ZoneOffset.UTC),endDate.toInstant().atOffset(ZoneOffset.UTC));
    }

}
