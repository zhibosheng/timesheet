package com.authright.timesheet;

import com.authright.timesheet.model.User;
import com.authright.timesheet.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;

//    @Test
//    public void findUsers(){
//        List<User> users = roleService.findUsers(2);
//        Assert.assertEquals(users.size(), 1);
//    }
}
