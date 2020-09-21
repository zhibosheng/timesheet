package com.authright.timesheet.repository;

import com.authright.timesheet.model.Contract;

public interface ContractDao {
    Contract save(Contract contract);
    Contract update(Contract contract);
    Contract getContractById(long contractId);
    Contract getContractByName(String contractName);
}
