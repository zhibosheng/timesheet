package com.authright.timesheet.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;
    private String groupName;
    private String groupDescription;

    @ManyToOne
    @JsonIgnore
    private User manager;

    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

    public Group(String groupName, String groupDescription, User manager, OffsetDateTime createTime, OffsetDateTime updateTime) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.manager = manager;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
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
