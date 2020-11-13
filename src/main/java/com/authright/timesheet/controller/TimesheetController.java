package com.authright.timesheet.controller;


import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class TimesheetController {

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

    @GetMapping("/timesheet/users/{startDate}/{endDate}")
    public List<Timesheet> findTimesheetByUsersAndDate(@RequestBody List<Long> userIdList, @PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return timesheetService.findTimesheetByUsersAndDate(userIdList,startDate.toInstant().atOffset(ZoneOffset.UTC),endDate.toInstant().atOffset(ZoneOffset.UTC));
    }

    @GetMapping("/timesheet/sendEmail/{email}/{startDate}/{endDate}")
    public List<Timesheet> sendTimesheetEmail(@RequestBody List<Long> userIdList, @PathVariable(name = "email") String email, @PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return timesheetService.sendTimesheetEmail(userIdList,email, startDate.toInstant().atOffset(ZoneOffset.UTC),endDate.toInstant().atOffset(ZoneOffset.UTC));
    }

}
