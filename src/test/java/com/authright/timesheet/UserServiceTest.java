package com.authright.timesheet;

import com.authright.timesheet.model.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findUserById() {
        User user = userService.findUserById(1);
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByName() {
        User user = userService.findUserByName("chance");
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByEmail() {
        User user = userService.findUserByEmail("liu.changsi@authright.com");
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByPhone() {
        User user = userService.findUserByPhone("6175951256");
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByCredentials() {
        User user = userService.findUserByCredentials("chance","password");
        Assert.assertEquals(user.getUserId(), 1);
    }


    @Test
    public void findManageGroups() {
        List<Group> manageGroups = userService.findManageGroups(6);
        Assert.assertEquals(manageGroups.size(), 1);
    }

    @Test
    public void findMyTimesheets() {
        List<Timesheet> myTimesheets = userService.findMyTimesheets(1);
        Assert.assertEquals(myTimesheets.size(), 28);
    }

    @Test
    public void findJoinGroups() {
        List<Group> joinGroups = userService.findJoinGroups(1);
        Assert.assertEquals(joinGroups.size(), 1);
    }

    @Test
    public void findRoles() {
        List<Role> roles = userService.findRoles(6);
        Assert.assertEquals(roles.size(), 1);
    }

    @Test
    public void findManageContracts() {
        List<Contract> contracts = userService.findManageContracts(6);
        Assert.assertEquals(contracts.size(), 1);
    }

    @Test
    public void findContracts() {
        List<Contract> contracts = userService.findContracts(1);
        Assert.assertEquals(contracts.size(), 1);
    }

    @Test
    public void findTimesheetByDate(){
        List<Timesheet> timesheets = userService.findTimesheetByDate(1,OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        Assert.assertEquals(timesheets.size(), 7);
    }

    @Test
    public void findTimesheetByUsersAndDate(){
        List<Long> userIdList = new ArrayList<>();
        userIdList.add(1L);
        userIdList.add(2L);
        List<Timesheet> timesheets = userService.findTimesheetByUsersAndDate(userIdList,OffsetDateTime.of(LocalDateTime.of(2020,8,10,0,0,0), ZoneOffset.ofHoursMinutes(0,0)),
                OffsetDateTime.of(LocalDateTime.of(2020,8,31,0,0,0),ZoneOffset.ofHoursMinutes(0,0)));
        Assert.assertEquals(timesheets.size(), 28);
    }
}
