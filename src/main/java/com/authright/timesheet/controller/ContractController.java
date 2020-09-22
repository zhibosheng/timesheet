package com.authright.timesheet.controller;

import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Group;
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
    public Contract getContractById(@PathVariable(name = "contractId") long contractId){
        return contractService.getContractById(contractId);
    }

    @GetMapping("/contract/name/{contractName}")
    public Contract getContractByName(@PathVariable(name = "contractName") String contractName){
        return contractService.getContractByName(contractName);
    }
}
