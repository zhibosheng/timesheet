package com.authright.timesheet;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.service.TimesheetService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class TimesheetServiceTest {
    @Autowired
    private TimesheetService timesheetService;

    @Test
    public void findTimesheetById() {
        Timesheet timesheet = timesheetService.findTimesheetById(1);
        Assert.assertEquals(timesheet.getTimesheetId(), 1);
    }
}
