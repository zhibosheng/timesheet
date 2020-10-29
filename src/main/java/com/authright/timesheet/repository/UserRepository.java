package com.authright.timesheet.repository;

import com.authright.timesheet.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    Optional<User> findUserByName(@Param("userName") String userName);

    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.phone=:phone")
    Optional<User> findUserByPhone(@Param("phone") String phone);

    @Query("SELECT u FROM User u WHERE u.userName=:userName and u.password=:password")
    Optional<User> findUserByCredentials(@Param("userName") String userName,@Param("password") String password);

    @Query("SELECT g FROM Group as g left join fetch g.manager as u WHERE u.userId = :userId")
    List<Group> findMangeGroups(@Param("userId") long userId);

    @Query("SELECT t FROM Timesheet as t left join fetch t.user as u WHERE u.userId = :userId")
    List<Timesheet> findMyTimesheets(@Param("userId") long userId);

    @Query("SELECT g FROM Group as g left join fetch g.users as u WHERE u.userId = :userId")
    List<Group> findJoinGroups(@Param("userId") long userId);

    @Query("SELECT r FROM Role as r left join fetch r.users as u WHERE u.userId = :userId")
    List<Role> findRoles(@Param("userId") long userId);

    @Query("SELECT c FROM Contract as c left join fetch c.users as u WHERE u.userId = :userId")
    List<Contract> findContracts(@Param("userId") long userId);

    @Query("SELECT t FROM Timesheet as t left join fetch t.user as u WHERE u.userId = :userId and t.timesheetDate BETWEEN :startDate AND :endDate")
    List<Timesheet> findTimesheetByDate(@Param("userId") long userId, @Param("startDate") OffsetDateTime startDate, @Param("endDate")OffsetDateTime endDate);

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();
}
