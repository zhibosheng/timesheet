package com.authright.timesheet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
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

    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Group> manageGroups = new ArrayList<>();

    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Contract> manageContracts = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Timesheet> myTimesheets = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "users_groups",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Group> joinGroups = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "users_contracts",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "contract_id")})
    private List<Contract> contracts = new ArrayList<>();

}
