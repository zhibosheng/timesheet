package com.authright.timesheet.model;


import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
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
}
