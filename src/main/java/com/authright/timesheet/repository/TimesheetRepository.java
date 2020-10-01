package com.authright.timesheet.repository;

import com.authright.timesheet.model.Timesheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
    @Query("SELECT t FROM Timesheet as t WHERE  t.timesheetDate BETWEEN :startDate AND :endDate")
    List<Timesheet> findTimesheetByDate(@Param("startDate")OffsetDateTime startDate, @Param("endDate")OffsetDateTime endDate);
}
