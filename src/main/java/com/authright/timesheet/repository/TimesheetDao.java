package com.authright.timesheet.repository;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;

public interface TimesheetDao {
    Timesheet save(Timesheet timesheet);
    Timesheet update(Timesheet timesheet);
    Timesheet getTimesheetById(long timesheetId);
}
