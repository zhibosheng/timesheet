package com.authright.timesheet.service;
import  java.io.*;
import java.time.LocalTime;
import java.util.List;

import com.authright.timesheet.model.Timesheet;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.stereotype.Service;


@Service
public class ExcelServiceImpl implements ExcelService{
    public boolean generateExcel(List<Timesheet> timesheets){
        try {
            String filename = "./TimeSheets.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("TimeSheet");

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("timesheetId");
            rowhead.createCell(1).setCellValue("contractName");
            rowhead.createCell(2).setCellValue("userName");
            rowhead.createCell(3).setCellValue("timesheetDate");
            rowhead.createCell(4).setCellValue("startTime");
            rowhead.createCell(5).setCellValue("endTime");
            rowhead.createCell(6).setCellValue("breakDeduction");
            rowhead.createCell(7).setCellValue("totalHour");
            rowhead.createCell(8).setCellValue("status");
            rowhead.createCell(9).setCellValue("createTime");
            rowhead.createCell(10).setCellValue("updateTime");

            double sumWorkingHours = 0;

            for (int i = 0; i < timesheets.size(); i++) {
                HSSFRow row = sheet.createRow((short)i+1);
                row.createCell(0).setCellValue(timesheets.get(i).getTimesheetId());
                row.createCell(1).setCellValue(timesheets.get(i).getContract().getContractName());
                row.createCell(2).setCellValue(timesheets.get(i).getUser().getUserName());
                row.createCell(3).setCellValue(timesheets.get(i).getTimesheetDate().toLocalDate().toString());
                row.createCell(4).setCellValue(timesheets.get(i).getStartTime().toLocalTime().toString());
                row.createCell(5).setCellValue(timesheets.get(i).getEndTime().toLocalTime().toString());
                row.createCell(6).setCellValue(timesheets.get(i).getBreakDeduction().toString());
                row.createCell(7).setCellValue(timesheets.get(i).getTotalHour().toString());
                row.createCell(8).setCellValue(timesheets.get(i).getStatus());
                row.createCell(9).setCellValue(timesheets.get(i).getCreateTime().toLocalDate().toString());
                row.createCell(10).setCellValue(timesheets.get(i).getUpdateTime().toLocalDate().toString());

                if (timesheets.get(i).getStatus().equals("confirmed")){

                    sumWorkingHours += (double) timesheets.get(i).getTotalHour().getHour();
                    sumWorkingHours += (double) timesheets.get(i).getTotalHour().getMinute()/60;
                }
            }

            HSSFRow rowfooter = sheet.createRow((short) timesheets.size()+2);
            rowfooter.createCell(7).setCellValue(sumWorkingHours);

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
            return true;
        } catch ( Exception ex ) {
            System.out.println(ex);
            return false;
        }
    }
}
