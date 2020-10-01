package com.authright.timesheet.controller;


import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
