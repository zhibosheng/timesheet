package com.authright.timesheet.repository;

import com.authright.timesheet.model.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContractRepository extends CrudRepository<Contract,Long> {
    @Query("SELECT c FROM Contract c WHERE c.contractName=:contractName")
    Optional<Contract> findContractByName(@Param("contractName") String contractName);
}
