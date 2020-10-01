package com.authright.timesheet.repository;

import com.authright.timesheet.model.Role;
import com.authright.timesheet.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT u FROM User as u left join fetch u.roles as r WHERE r.roleId = :roleId")
    List<User> findUsers(@Param("roleId") long roleId);
}
