package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;

public interface ContractService {
    Contract save(Contract contract);
    Contract update(Contract contract);
    Contract getContractById(long contractId);
    Contract getContractByName(String contractName);
}
