package com.authright.timesheet.repository;

import com.authright.timesheet.model.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet,Long> {

}
