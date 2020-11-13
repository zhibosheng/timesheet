package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;


import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

public interface TimesheetService {
    Timesheet save(Timesheet timesheet);

    Timesheet update(Timesheet timesheet);

    Timesheet findTimesheetById(long timesheetId);

    List<Timesheet> findTimesheetByDate(OffsetDateTime startDate, OffsetDateTime endDate);

    List<Timesheet> findTimesheetByUsersAndDate(List<Long> userIdList, OffsetDateTime startDate, OffsetDateTime endDate);

    List<Timesheet> sendTimesheetEmail(List<Long> userIdList, String email, OffsetDateTime startDate, OffsetDateTime endDate);
}
