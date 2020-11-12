package com.authright.timesheet.service;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private UserService userService;

    @Autowired
    private ContractRepository contractRepository;

    public Contract save(Contract contract) {
        contract.setCreateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        contract.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return contractRepository.save(contract);
    }

    public Contract update(Contract contract) {
        contract.setCreateTime(contractRepository.findById(contract.getContractId()).get().getCreateTime());
        contract.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        return contractRepository.save(contract);
    }

    public Contract findContractById(long contractId) {
        return contractRepository.findById(contractId).get();
    }

    public Contract findContractByName(String contractName) {
        return contractRepository.findContractByName(contractName).get();
    }

    public List<Timesheet> findContractTimesheets(long contractId) {
        return contractRepository.findContractTimesheets(contractId);
    }

    public List<User> findUsers(long contractId){
        return contractRepository.findUsers(contractId);
    };

    public List<Timesheet> findTimesheetByDate(long contractId, OffsetDateTime startDate, OffsetDateTime endDate){
        return contractRepository.findTimesheetByDate(contractId, startDate,endDate);
    };

    public Contract addUser(Contract contract, User user){
        List<Contract> contracts = user.getContracts();
        contracts.add(contract);
        user.setContracts(contracts);
        contract.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        userService.update(user);
        return contractRepository.save(contract);
    };

    public Contract deleteUser(Contract contract, User user){
        List<Contract> contracts = user.getContracts();
        contracts.remove(contract);
        user.setContracts(contracts);
        contract.setUpdateTime(new Date().toInstant()
                .atOffset(ZoneOffset.UTC));
        userService.update(user);
        return contractRepository.save(contract);
    };

    public List<Contract> findAllContracts(){
        return contractRepository.findAllContracts();
    };
}
