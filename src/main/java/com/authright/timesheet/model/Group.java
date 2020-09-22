package com.authright.timesheet.model;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    private OffsetDateTime createTime;
    private OffsetDateTime updateTime;
}
