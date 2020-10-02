package com.authright.timesheet;

import com.authright.timesheet.service.EncoderService;

import com.authright.timesheet.service.EncoderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EncodeServiceTest {

    private EncoderService encoderService = new EncoderServiceImpl();
    
    @Test
    public void encodeExcel(){
        boolean flag = encoderService.encodeExcel();
        Assert.assertEquals(flag, true);
    }
}
