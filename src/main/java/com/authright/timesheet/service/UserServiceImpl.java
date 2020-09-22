package com.authright.timesheet.service;

import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        return userRepository.save(user);
    }

    public User findUserById(long userId){
        return userRepository.findById(userId).get();
    }

    public User findUserByName(String userName){
        return userRepository.findUserByName(userName).get();
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email).get();
    }

    public User findUserByPhone(String phone){
        return userRepository.findUserByPhone(phone).get();
    }

}
