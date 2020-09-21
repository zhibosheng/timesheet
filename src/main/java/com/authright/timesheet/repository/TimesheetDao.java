package com.authright.timesheet.repository;

import com.authright.timesheet.model.Timesheet;

public interface TimesheetDao {
    Timesheet save(Timesheet timesheet);
    Timesheet update(Timesheet timesheet);
    Timesheet getTimesheetById(long timesheetId);
}
