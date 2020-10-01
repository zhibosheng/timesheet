package com.authright.timesheet;


import com.authright.timesheet.model.Contract;
import com.authright.timesheet.model.Timesheet;
import com.authright.timesheet.model.User;
import com.authright.timesheet.service.ContractService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void findContractTimesheets() {
        List<Timesheet> contractTimesheets = contractService.findContractTimesheets(1);
        Assert.assertEquals(contractTimesheets.size(), 70);
    }

    @Test
    public void findUsers(){
        List<User> users = contractService.findUsers(1);
        Assert.assertEquals(users.size(), 2);
    }
}
