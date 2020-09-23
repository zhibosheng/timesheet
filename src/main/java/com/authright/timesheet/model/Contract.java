package com.authright.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @ManyToOne
    @JsonIgnore
    private User manager;


    private String contractName;
    private String company;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

    @OneToMany(mappedBy = "contract" )
    @JsonIgnore
    private List<Timesheet> contractTimesheets = new ArrayList<>();

    public Contract(User manager, String contractName, String company, OffsetDateTime startDate, OffsetDateTime endDate, OffsetDateTime createTime, OffsetDateTime updateTime) {
        this.manager = manager;
        this.contractName = contractName;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
