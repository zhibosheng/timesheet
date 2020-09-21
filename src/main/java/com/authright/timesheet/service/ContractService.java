package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.repository.ContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractDao contractDao;

    public Contract save(Contract contract){
        return contractDao.save(contract);
    }

    public Contract update(Contract contract){
        return contractDao.update(contract);
    }

    public Contract getContractById(long contractId){
        return contractDao.getContractById(contractId);
    }

    public Contract getContractByName(String contractName){
        return contractDao.getContractByName(contractName);
    }
}
