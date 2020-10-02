package com.authright.timesheet;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.service.ContractService;
import com.authright.timesheet.service.ExcelService;
import com.authright.timesheet.service.TimesheetService;
import com.authright.timesheet.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class ExcelServiceTest {
    @Autowired
    private ExcelService excelService;

    @Autowired
    private UserService userService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TimesheetService timesheetService;

    @Test
    public void generateExcelByDate(){
        List<Timesheet> timesheets = timesheetService.findTimesheetByDate(OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        boolean flag = excelService.generateExcel(timesheets);
        Assert.assertEquals(flag, true);
    }

    @Test
    public void generateUserExcelByDate(){
        List<Timesheet> timesheets = userService.findTimesheetByDate(1,OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        boolean flag = excelService.generateExcel(timesheets);
        Assert.assertEquals(flag, true);
    }

    @Test
    public void generateContractExcelByDate(){
        List<Timesheet> timesheets = contractService.findTimesheetByDate(1,OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
        OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        boolean flag = excelService.generateExcel(timesheets);
        Assert.assertEquals(flag, true);
    }
}
