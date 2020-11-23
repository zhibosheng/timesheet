package com.authright.timesheet.task;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.TimesheetService;
import com.authright.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private UserService userService;

    @Autowired
    private TimesheetService timesheetService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void test(){
        List<User> users = userService.findAllUsers();
        for(User user:users){
            List<Contract> contracts = userService.findContracts(user.getUserId());
            for(Contract contract: contracts){
                Timesheet timesheet = new Timesheet();
                timesheet.setContract(contract);
                timesheet.setUser(user);
                timesheet.setTimesheetDate(new Date().toInstant().atOffset(ZoneOffset.UTC));
                timesheet.setStartTime(new Date().toInstant().atOffset(ZoneOffset.UTC));
                timesheet.setEndTime(new Date().toInstant().atOffset(ZoneOffset.UTC));
                timesheet.setBreakDeduction(LocalTime.of(0, 0, 0));
                timesheet.setTotalHour(LocalTime.of(0, 0, 0));
                timesheet.setNote("");
                timesheet.setStatus("confirmed");
                timesheet.setCreateTime(new Date().toInstant().atOffset(ZoneOffset.UTC));
                timesheet.setUpdateTime(new Date().toInstant().atOffset(ZoneOffset.UTC));
                timesheetService.save(timesheet);
            }
        }
        System.out.println("insert timesheet success");
    }
}
