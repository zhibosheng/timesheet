package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Timesheet;

import java.util.List;

public interface ContractService {
    Contract save(Contract contract);
    Contract update(Contract contract);
    Contract findContractById(long contractId);
    Contract findContractByName(String contractName);
    List<Timesheet> findContractTimesheets(long contractId);
}
