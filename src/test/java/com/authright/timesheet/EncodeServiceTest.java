package com.authright.timesheet;

import com.authright.timesheet.service.EncodeService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EncodeServiceTest {
    @Autowired
    private EncodeService encodeService;
    
    @Test
    public void encodeExcel(){
        boolean flag = encodeService.encodeExcel();
        Assert.assertEquals(flag, true);
    }
}
