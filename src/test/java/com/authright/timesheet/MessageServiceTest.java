package com.authright.timesheet;

import com.authright.timesheet.service.MessageService;
import com.authright.timesheet.service.MessageServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class MessageServiceTest {
    @Autowired
    private MessageServiceImpl messageService;

    @Test
    public void sendEmail(){
        try{
            boolean flag = messageService.sendEmail("chance93418@gmail.com","TimeSheets","TimeSheets test","TimeSheet test");
            Assert.assertEquals(flag, true);
        } catch (Exception ex){
            Assert.assertEquals(false, true);
        }
    }
}
