package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.repository.TimesheetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private TimesheetDao timesheetDao;

    public Timesheet save(Timesheet timesheet){
        return timesheetDao.save(timesheet);
    }

    public Timesheet update(Timesheet timesheet){
        return timesheetDao.update(timesheet);
    }

    public Timesheet getTimesheetById(long timesheetId){
        return timesheetDao.getTimesheetById(timesheetId);
    }
}
