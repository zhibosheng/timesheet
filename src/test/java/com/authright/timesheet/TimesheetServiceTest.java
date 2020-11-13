package com.authright.timesheet;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.service.TimesheetService;
import com.authright.timesheet.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class TimesheetServiceTest {

    @Autowired
    private TimesheetService timesheetService;

    @Test
    public void findTimesheetById() {
        Timesheet timesheet = timesheetService.findTimesheetById(1l);
        Assert.assertEquals(timesheet.getTimesheetId(), 1l);
        Assert.assertEquals(timesheet.getUser().getUserId(), 2l);
        Assert.assertEquals(timesheet.getNote(), "ReactJS");
    }

    @Test
    public void findTimesheetByDate(){
        List<Timesheet> timesheets = timesheetService.findTimesheetByDate(OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0),ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        Assert.assertEquals(timesheets.size(), 28);
    }

    @Test
    public void findTimesheetByUsersAndDate(){
        List<Long> userIdList = new ArrayList<>();
        userIdList.add(1L);
        userIdList.add(2L);
        List<Timesheet> timesheets = timesheetService.findTimesheetByUsersAndDate(userIdList,OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        Assert.assertEquals(timesheets.size(), 28);
    }

    @Test
    public void sendTimesheetEmail(){
        List<Long> userIdList = new ArrayList<>();
        userIdList.add(1L);
        userIdList.add(2L);
        List<Timesheet> timesheets = timesheetService.sendTimesheetEmail(userIdList,"zhibo.sheng@authright.com",OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        Assert.assertEquals(timesheets.size(), 28);
    }
}
