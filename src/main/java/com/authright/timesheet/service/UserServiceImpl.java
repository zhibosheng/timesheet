package com.authright.timesheet.service;

import com.authright.timesheet.model.*;
import com.authright.timesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        user.setCreateTime(userRepository.findById(user.getUserId()).get().getCreateTime());
        user.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
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

    public User findUserByCredentials(String userName, String password){
        return userRepository.findUserByCredentials(userName,password).get();
    }

    public User changePassword(long userId, String oldPassword, String newPassword){
        User user = userRepository.findById(userId).get();
        if(oldPassword.equals(user.getPassword())){
            user.setPassword(newPassword);
        }
        user.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return userRepository.save(user);
    }

    public List<Timesheet> findMyTimesheets(long userId) {
        return userRepository.findMyTimesheets(userId);
    }

    public List<Group> findManageGroups(long userId) {
        return userRepository.findMangeGroups(userId);
    }

    public List<Group> findJoinGroups(long userId) {
        return userRepository.findJoinGroups(userId);
    }

    public List<Role> findRoles(long userId) {
        return userRepository.findRoles(userId);
    }

    public List<Contract> findManageContracts(long userId) {
        return userRepository.findManageContracts(userId);
    }

    public List<Contract> findContracts(long userId) {
        return userRepository.findContracts(userId);
    }

    public List<Timesheet> findTimesheetByDate(long userId, OffsetDateTime startDate, OffsetDateTime endDate){
        return userRepository.findTimesheetByDate(userId, startDate,endDate);
    };

    public List<Timesheet> findTimesheetByUsersAndDate(List<Long> userIdList, OffsetDateTime startDate, OffsetDateTime endDate){
        List<Timesheet> timesheets = new ArrayList<>();
        for(long userId:userIdList){
            timesheets.addAll(userRepository.findTimesheetByDate(userId,startDate,endDate));
        }
        return timesheets;
    };

    public List<User> findAllUsers(){
        return userRepository.findAllUsers();
    }
}
