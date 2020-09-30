package com.authright.timesheet.service;

import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;

import java.util.List;
import java.util.Set;

public interface GroupService {
    Group save(Group group);
    Group update(Group group);
    Group findGroupById(long groupId);
    Group findGroupByName(String groupName);
    List<User> findUsers(long groupId);
}
