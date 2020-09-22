package com.authright.timesheet.repository;

import com.authright.timesheet.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    Optional<User> findUserByName(@Param("userName") String userName);
    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findUserByEmail(@Param("email") String email);
    @Query("SELECT u FROM User u WHERE u.phone=:phone")
    Optional<User> findUserByPhone(@Param("phone") String phone);
}
