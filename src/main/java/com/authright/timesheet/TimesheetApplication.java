package com.authright.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan(basePackages = {"timesheet"})
@EnableScheduling
public class TimesheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }

}
