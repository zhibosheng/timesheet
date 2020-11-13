package com.authright.timesheet;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableAdminServer
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.authright.timesheet"})
@EnableScheduling
public class TimesheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApplication.class, args);
    }

    @Bean
    public AmazonS3 getAmazonS3(){
        return AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }


}
