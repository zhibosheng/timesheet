package com.authright.timesheet.service;

import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group){
        return groupRepository.save(group);
    }

    public Group update(Group group){
        return groupRepository.save(group);
    }

    public Group findGroupById(long groupId){
        return groupRepository.findById(groupId).get();
    }

    public Group findGroupByName(String groupName){
        return groupRepository.findGroupByName(groupName).get();
    }

    public List<User> findUsers(long groupId){
        return groupRepository.findUsers(groupId);
    };
}
