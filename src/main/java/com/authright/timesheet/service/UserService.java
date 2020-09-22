package com.authright.timesheet.service;

import com.authright.timesheet.model.User;

public interface UserService {
    User save(User user);
    User update(User user);
    User getUserById(long userId);
    User getUserByName(String userName);
    User getUserByEmail(String email);
    User getUserByPhone(String phone);
}
