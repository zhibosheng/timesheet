package com.authright.timesheet;


import com.authright.timesheet.model.Contract;
import com.authright.timesheet.service.ContractService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TimesheetApplication.class)
public class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @Test
    public void findContractById(){
        Contract contract = contractService.findContractById(1);
        Assert.assertEquals(contract.getContractId(),1);
    }

    @Test
    public void findContractByName(){
        Contract contract = contractService.findContractByName("FullStackTrainingContract");
        Assert.assertEquals(contract.getContractId(),1);
    }
}
