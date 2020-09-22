package com.authright.timesheet.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "timesheets")
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private long timesheetId;


    private Contract contract;


    private User user;


    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private OffsetDateTime breakDeduction;
    private OffsetDateTime totalHour;
    private String status;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;
}
