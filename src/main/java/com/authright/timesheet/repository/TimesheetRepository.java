package com.authright.timesheet.repository;

import com.authright.timesheet.model.Timesheet;
import org.springframework.data.repository.CrudRepository;

public interface TimesheetRepository extends CrudRepository<Timesheet,Long> {

}
