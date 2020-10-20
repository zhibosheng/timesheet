package com.authright.timesheet.controller;

import com.authright.timesheet.model.Contract;

import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/contract")
    public Contract save(@RequestBody Contract contract) {
        return contractService.save(contract);
    }

    @PutMapping("/contract")
    public Contract update(@RequestBody Contract contract) {
        return contractService.update(contract);
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

    @GetMapping("/contract/users/{contractId}}")
    public List<User> findUsers(@PathVariable(name = "contractId") long contractId) {
        return contractService.findUsers(contractId);
    }
}

