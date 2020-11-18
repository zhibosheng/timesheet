package com.authright.timesheet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "timesheets")
@Data
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timesheetId;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private OffsetDateTime timesheetDate;

    private OffsetDateTime startTime;

    private OffsetDateTime endTime;
    private LocalTime breakDeduction;
    private LocalTime totalHour;
    private String note;
    private String status;

    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

}
