package com.authright.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "timesheets")
@Data
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long timesheetId;

    @ManyToOne
    @JsonIgnore
    private Contract contract;

    @ManyToOne
    @JsonIgnore
    private User user;

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private OffsetDateTime breakDeduction;
    private OffsetDateTime totalHour;
    private String status;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

}
