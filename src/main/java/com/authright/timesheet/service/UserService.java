package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.Role;
import com.authright.timesheet.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);
    User findUserById(long userId);
    User findUserByName(String userName);
    User findUserByEmail(String email);
    User findUserByPhone(String phone);
    List<Group> findJoinGroups(long userId);
    List<Role> findRoles(long userId);
    List<Contract> findContracts(long userId);
}
