package com.authright.timesheet.controller;

import com.authright.timesheet.model.Contract;

import com.authright.timesheet.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/contract")
    public Contract save(@RequestBody Contract contract){
        return contractService.save(contract);
    }

    @PutMapping("/contract")
    public Contract update(@RequestBody Contract contract){
        return contractService.update(contract);
    }

    @GetMapping("/contract/{contractId}")
    public Contract findContractById(@PathVariable(name = "contractId") long contractId){
        return contractService.findContractById(contractId);
    }

    @GetMapping("/contract/name/{contractName}")
    public Contract findContractByName(@PathVariable(name = "contractName") String contractName){
        return contractService.findContractByName(contractName);
    }
}
