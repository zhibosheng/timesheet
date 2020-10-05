package com.authright.timesheet;

import com.authright.timesheet.service.EncodeService;

import com.authright.timesheet.service.EncodeServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class EncodeServiceTest {

    private EncodeService encodeService = new EncodeServiceImpl();
    
    @Test
    public void encodeExcel(){
        boolean flag = encodeService.encodeExcel();
        Assert.assertEquals(flag, true);
    }
}
