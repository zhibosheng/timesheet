package com.authright.timesheet.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;


    private User manager;


    private String contractName;
    private String company;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;
}
