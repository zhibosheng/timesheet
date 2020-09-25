package com.authright.timesheet;

import com.authright.timesheet.model.User;
import com.authright.timesheet.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findUserById(){
        User user = userService.findUserById(1);
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByName(){
        User user = userService.findUserByName("chance");
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByEmail(){
        User user = userService.findUserByEmail("liu.changsi@authright.com");
        Assert.assertEquals(user.getUserId(), 1);
    }

    @Test
    public void findUserByPhone(){
        User user = userService.findUserByPhone("6175951256");
        Assert.assertEquals(user.getUserId(), 1);
    }
}
