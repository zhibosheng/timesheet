package com.authright.timesheet.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(cron = "*/10 * * * * *")
    public void test(){
        System.out.println("test");
    }
}
