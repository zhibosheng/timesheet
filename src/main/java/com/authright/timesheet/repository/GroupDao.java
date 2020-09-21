package com.authright.timesheet.repository;

import com.authright.timesheet.model.Group;

public interface GroupDao {
    Group save(Group group);
    Group update(Group group);
    Group getGroupById(long groupId);
    Group getGroupByName(String groupName);
}
