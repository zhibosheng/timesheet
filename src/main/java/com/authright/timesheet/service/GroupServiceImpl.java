package com.authright.timesheet.service;

import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.GroupRepository;
import com.authright.timesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private UserService userService;

    @Autowired
    private GroupRepository groupRepository;

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group update(Group group) {
        group.setCreateTime(groupRepository.findById(group.getGroupId()).get().getCreateTime());
        group.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return groupRepository.save(group);
    }

    public Group findGroupById(long groupId) {
        return groupRepository.findById(groupId).get();
    }

    public Group findGroupByName(String groupName) {
        return groupRepository.findGroupByName(groupName).get();
    }

    public List<User> findUsers(long groupId) {
        return groupRepository.findUsers(groupId);
    }

    public Group addUser(Group group, User user){
        List joinGroups = user.getJoinGroups();
        joinGroups.add(group);
        user.setJoinGroups(joinGroups);
        group.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        userService.update(user);
        return groupRepository.save(group);
    }

    public Group deleteUser(Group group, User user){
        List joinGroups = user.getJoinGroups();
        joinGroups.remove(group);
        user.setJoinGroups(joinGroups);
        group.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        userService.update(user);
        return groupRepository.save(group);
    }

    public List<Group> findAllGroups(){
        return groupRepository.findAllGroups();
    };
}
