package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;

public interface ContractService {
    Contract save(Contract contract);
    Contract update(Contract contract);
    Contract findContractById(long contractId);
    Contract findContractByName(String contractName);
}
