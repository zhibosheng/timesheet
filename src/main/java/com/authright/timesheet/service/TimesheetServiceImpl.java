package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public Timesheet save(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public Timesheet update(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public Timesheet findTimesheetById(long timesheetId) {
        return timesheetRepository.findById(timesheetId).get();
    }
}
