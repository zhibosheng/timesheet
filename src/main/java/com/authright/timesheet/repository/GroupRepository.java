package com.authright.timesheet.repository;

import com.authright.timesheet.model.Group;
import com.authright.timesheet.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    @Query("SELECT g FROM Group g WHERE g.groupName=:groupName")
    Optional<Group> findGroupByName(@Param("groupName") String groupName);

    @Query("SELECT u FROM User as u left join fetch u.joinGroups as g WHERE g.groupId = :groupId")
    List<User> findUsers(@Param("groupId") long groupId);

    @Query("SELECT g FROM Group g")
    List<Group> findAllGroups();
}
