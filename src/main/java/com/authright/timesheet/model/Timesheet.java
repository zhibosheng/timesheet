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

    public Timesheet(Contract contract, User user, OffsetDateTime startTime, OffsetDateTime endTime, OffsetDateTime breakDeduction, OffsetDateTime totalHour, String status, OffsetDateTime createTime, OffsetDateTime updateTime) {
        this.contract = contract;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.breakDeduction = breakDeduction;
        this.totalHour = totalHour;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public OffsetDateTime getBreakDeduction() {
        return breakDeduction;
    }

    public void setBreakDeduction(OffsetDateTime breakDeduction) {
        this.breakDeduction = breakDeduction;
    }

    public OffsetDateTime getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(OffsetDateTime totalHour) {
        this.totalHour = totalHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
