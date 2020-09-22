package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;

public interface TimesheetService {
    Timesheet save(Timesheet timesheet);
    Timesheet update(Timesheet timesheet);
    Timesheet getTimesheetById(long timesheetId);
}
