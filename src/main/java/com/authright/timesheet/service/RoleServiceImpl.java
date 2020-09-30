package com.authright.timesheet.service;

import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

//    public List<User> findUsers(long groupId){
//        return roleRepository.findUsers(groupId);
//    };
}
