package com.authright.timesheet.controller;

import com.authright.timesheet.model.Contract;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.ContractService;
import com.authright.timesheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class ContractController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContractService contractService;

    @PostMapping("/contract")
    public Contract save(@RequestBody Contract contract) {
        return contractService.save(contract);
    }

    @PostMapping("/createContract/{contractName}/{company}/{managerName}")
    public Contract createContract(@PathVariable(name = "contractName") String contractName, @PathVariable(name = "company") String company,  @PathVariable(name = "managerName") String managerName) {
        Contract contract = new Contract();
        contract.setContractName(contractName);
        contract.setCompany(company);
        User user = userService.findUserByName(managerName);
        contract.setManager(user);
        return contractService.save(contract);
    }

    @PutMapping("/contract")
    public Contract update(@RequestBody Contract contract) {
        Contract tempContractInfo = contractService.findContractById(contract.getContractId());
        if(!tempContractInfo.getContractName().equals("")){
            tempContractInfo.setContractName(contract.getContractName());
        }
        if(!tempContractInfo.getCompany().equals("")){
            tempContractInfo.setCompany(contract.getCompany());
        }
        if(!tempContractInfo.getStartDate().equals("")){
            tempContractInfo.setStartDate(contract.getStartDate());
        }
        if(!tempContractInfo.getEndDate().equals("")){
            tempContractInfo.setEndDate(contract.getEndDate());
        }
        return contractService.update(tempContractInfo);
    }

    @GetMapping("/contract/{contractId}")
    public Contract findContractById(@PathVariable(name = "contractId") long contractId) {
        return contractService.findContractById(contractId);
    }

    @GetMapping("/contract/name/{contractName}")
    public Contract findContractByName(@PathVariable(name = "contractName") String contractName) {
        return contractService.findContractByName(contractName);
    }

    @GetMapping("/contract/contractTimesheets/{contractId}")
    public List<Timesheet> findContractTimesheets(@PathVariable(name = "contractId") long contractId) {
        return contractService.findContractTimesheets(contractId);
    }

    @GetMapping("/contract/contractTimesheets/{contractId}/{startDate}/{endDate}")
    public List<Timesheet> findTimesheetsByDate(@PathVariable(name = "contractId") long contractId, @PathVariable(name = "startDate") Date startDate, @PathVariable(name = "endDate") Date endDate) {
        return contractService.findTimesheetByDate(contractId, startDate.toInstant().atOffset(ZoneOffset.UTC),  endDate.toInstant().atOffset(ZoneOffset.UTC));
    }

    @GetMapping("/contract/users/{contractId}")
    public List<User> findUsers(@PathVariable(name = "contractId") long contractId) {
        return contractService.findUsers(contractId);
    }

    @PostMapping("/contract/addUser/{contractId}/{userId}")
    public Contract addUser(@PathVariable(name = "contractId") long contractId, @PathVariable(name = "userId") long userId){
        User user = userService.findUserById(userId);
        Contract contract = contractService.findContractById(contractId);
        return contractService.addUser(contract, user);
    }

    @PostMapping("/contract/addUserByName/{contractId}/{userName}")
    public List<User> addUserByName(@PathVariable(name = "contractId") long contractId, @PathVariable(name = "userName") String userName){
        User user = userService.findUserByName(userName);
        Contract contract = contractService.findContractById(contractId);
        contractService.addUser(contract, user);
        return contractService.findUsers(contractId);
    }


    @PostMapping("/contract/deleteUser/{contractId}/{userId}")
    public List<User> deleteUser(@PathVariable(name = "contractId") long contractId, @PathVariable(name = "userId") long userId){
        User user = userService.findUserById(userId);
        Contract contract = contractService.findContractById(contractId);
        contractService.deleteUser(contract, user);
        return contractService.findUsers(contractId);
    }

    @GetMapping("/contract/allContracts")
    public List<Contract> findAllContracts() {
        return contractService.findAllContracts();
    }
}

