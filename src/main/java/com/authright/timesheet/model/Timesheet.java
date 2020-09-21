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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id")
    private Contract contract;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @Column(name = "start_time")
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @Column(name = "break_deduction")
    private OffsetDateTime breakDeduction;

    @Column(name = "total_hour")
    private OffsetDateTime totalHour;

    @Column(name = "status")
    private String status;

    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @Column(name = "update_time")
    private OffsetDateTime updateTime;
}
