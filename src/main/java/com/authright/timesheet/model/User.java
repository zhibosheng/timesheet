package com.authright.timesheet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String avatarUrl;
    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;

    @OneToMany(mappedBy = "manager" )
    @JsonIgnore
    private List<Group> manageGroups = new ArrayList<>();

    @OneToMany(mappedBy = "manager" )
    @JsonIgnore
    private List<Contract> manageContracts = new ArrayList<>();

    @OneToMany(mappedBy = "user" )
    @JsonIgnore
    private List<Timesheet> myTimesheets = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "users_groups",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id")})
    private List<Group> joinGroups = new ArrayList<>();

}
