package com.authright.timesheet.service;

import com.authright.timesheet.model.Group;

public interface GroupService {
    Group save(Group group);
    Group update(Group group);
    Group getGroupById(long groupId);
    Group getGroupByName(String groupName);
}
