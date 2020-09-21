package com.authright.timesheet.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private long contractId;


    private User manager;

    @Column(name = "contract_name")
    private String contractName;

    @Column(name = "company")
    private String company;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    private OffsetDateTime endDate;

    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @Column(name = "update_time")
    private OffsetDateTime updateTime;
}
