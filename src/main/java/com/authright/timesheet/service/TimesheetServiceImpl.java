package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.repository.TimesheetRepository;
import com.authright.timesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private EncodeService encodeService;

    public Timesheet save(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public Timesheet update(Timesheet timesheet) {
        timesheet.setCreateTime(timesheetRepository.findById(timesheet.getTimesheetId()).get().getCreateTime());
        timesheet.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return timesheetRepository.save(timesheet);
    }

    public Timesheet findTimesheetById(long timesheetId) {
        return timesheetRepository.findById(timesheetId).get();
    }

    public List<Timesheet> findTimesheetByDate(OffsetDateTime startDate, OffsetDateTime endDate){
        return timesheetRepository.findTimesheetByDate(startDate,endDate);
    };

    public List<Timesheet> findTimesheetByUsersAndDate(List<Long> userIdList, OffsetDateTime startDate, OffsetDateTime endDate){
        List<Timesheet> timesheets = new ArrayList<>();
        for(long userId:userIdList){
            timesheets.addAll(userRepository.findTimesheetByDate(userId,startDate,endDate));
        }
        return timesheets;
    };

    public List<Timesheet> sendTimesheetEmail(List<Long> userIdList, String email, OffsetDateTime startDate, OffsetDateTime endDate){
        List<Timesheet> timesheets = new ArrayList<>();
        for(long userId:userIdList){
            timesheets.addAll(userRepository.findTimesheetByDate(userId,startDate,endDate));
        }
        try{
            excelService.generateExcel(timesheets);
            encodeService.encodeExcel();
            boolean flag = messageService.sendEmail(email,"TimeSheets","TimeSheets test","TimeSheet test");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return timesheets;
    };
}
