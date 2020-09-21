package com.authright.timesheet.service;

import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User save(User user){
        return userDao.save(user);
    }

    public User update(User user){
        return userDao.update(user);
    }

    public User getUserById(long userId){
        return userDao.getUserById(userId);
    }

    public User getUserByName(String userName){
        return userDao.getUserByName(userName);
    }

    public User getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }

    public User getUserByPhone(String phone){
        return userDao.getUserByPhone(phone);
    }

}
