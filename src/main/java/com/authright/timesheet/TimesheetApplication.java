package com.authright.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"timesheet"})
public class TimesheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }

}
