package com.authright.timesheet;


import com.authright.timesheet.service.FileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class FileServiceTest {
    private String bucket = "timesheet-avatars";

    @Autowired
    private FileService fileService;

    @Test
    public void getObjectUrl() {
        URL url  = fileService.getObjectUrl("download.png");
        Assert.assertEquals(url.toString(), "https://timesheet-avatars.s3.amazonaws.com/download.png");
    }
}
