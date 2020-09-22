package com.authright.timesheet.service;

import com.authright.timesheet.model.User;

public interface UserService {
    User save(User user);
    User update(User user);
    User findUserById(long userId);
    User findUserByName(String userName);
    User findUserByEmail(String email);
    User findUserByPhone(String phone);
}
