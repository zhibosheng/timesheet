package com.authright.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groupId;
    private String groupName;
    private String groupDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "manager_id")
    private User manager;

    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

    @ManyToMany(mappedBy = "joinGroups",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

}
