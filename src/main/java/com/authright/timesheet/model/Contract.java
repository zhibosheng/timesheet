package com.authright.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contracts")
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "manager_id")
    private User manager;


    private String contractName;
    private String company;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

    @OneToMany(mappedBy = "contract")
    @JsonIgnore
    private List<Timesheet> contractTimesheets = new ArrayList<>();

    @ManyToMany(mappedBy = "contracts")
    @JsonIgnore
    private List<User> users = new ArrayList<>();
}
