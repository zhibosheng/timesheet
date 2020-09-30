package com.authright.timesheet;


import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.Role;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.GroupService;
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
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Test
    public void findGroupById(){
        Group group = groupService.findGroupById(1);
        Assert.assertEquals(group.getGroupId(),1);
    }

    @Test
    public void findGroupByName(){
        Group group = groupService.findGroupByName("Full Stack Training Team");
        Assert.assertEquals(group.getGroupId(),1);
    }

    @Test
    public void findUsers(){
        List<User> users = groupService.findUsers(1);
        Assert.assertEquals(users.size(), 2);
    }
}
