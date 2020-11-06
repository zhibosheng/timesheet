package com.authright.timesheet.repository;

import com.authright.timesheet.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {
    @Query("SELECT c FROM Contract c WHERE c.contractName=:contractName")
    Optional<Contract> findContractByName(@Param("contractName") String contractName);

    @Query("SELECT t FROM Timesheet as t left join fetch t.contract as c WHERE c.contractId = :contractId")
    List<Timesheet> findContractTimesheets(@Param("contractId") long contractId);

    @Query("SELECT u FROM User as u left join fetch u.contracts as c WHERE c.contractId = :contractId")
    List<User> findUsers(@Param("contractId") long contractId);

    @Query("SELECT t FROM Timesheet as t  left join fetch t.contract as c WHERE c.contractId = :contractId and t.timesheetDate BETWEEN :startDate AND :endDate")
    List<Timesheet> findTimesheetByDate(@Param("contractId") long contractId, @Param("startDate") OffsetDateTime startDate, @Param("endDate")OffsetDateTime endDate);

    @Query("SELECT c FROM Contract c")
    List<Contract> findAllContracts();
}
