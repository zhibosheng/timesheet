package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.repository.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetDao timesheetDao;

    public Timesheet save(Timesheet timesheet){
        return TimesheetDao.save(timesheet);
    }

    public Timesheet update(Timesheet timesheet){
        return TimesheetDao.update(timesheet);
    }

    public Timesheet getTimesheetById(long timesheetId){
        return TimesheetDao.getTimesheetById(timesheetId);
    }
}
