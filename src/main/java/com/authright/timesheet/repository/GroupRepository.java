package com.authright.timesheet.repository;

import com.authright.timesheet.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group,Long> {
    @Query("SELECT g FROM Group g WHERE g.groupName=:groupName")
    Optional<Group> findGroupByName(@Param("groupName")String groupName);
}
