package com.authright.timesheet.service;

import com.authright.timesheet.model.Group;
import com.authright.timesheet.repository.GroupDao;
import com.authright.timesheet.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupDao groupDao;

    public Group save(Group group){
        return groupDao.save(group);
    }

    public Group update(Group group){
        return groupDao.update(group);
    }

    public Group getGroupById(long groupId){
        return groupDao.getGroupById(groupId);
    }

    public Group getGroupByName(String groupName){
        return groupDao.getGroupByName(groupName);
    }
}
