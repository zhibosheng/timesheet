package com.authright.timesheet;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        GroupServiceTest.class,
        ContractServiceTest.class,
        TimesheetServiceTest.class,
        RoleServiceTest.class,
//        ExcelServiceTest.class,
//        EncodeServiceTest.class,
        FileServiceTest.class
})
public class TestAll {
}
