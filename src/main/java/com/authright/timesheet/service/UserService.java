package com.authright.timesheet.service;

import com.authright.timesheet.model.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

public interface UserService {
    User save(User user);

    User update(User user);

    User findUserById(long userId);

    User findUserByName(String userName);

    User findUserByEmail(String email);

    User findUserByPhone(String phone);

    User findUserByCredentials(String userName, String password);

    User changePassword(long userId, String oldPassword, String newPassword);

    List<Group> findManageGroups(long userId);

    List<Timesheet> findMyTimesheets(long userId);

    List<Group> findJoinGroups(long userId);

    List<Role> findRoles(long userId);

    List<Contract> findManageContracts(long userId);

    List<Contract> findContracts(long userId);

    List<Timesheet> findTimesheetByDate(long userId, OffsetDateTime startDate, OffsetDateTime endDate);

    List<User> findAllUsers();
}
