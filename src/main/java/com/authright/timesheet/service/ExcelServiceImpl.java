package com.authright.timesheet.service;
import  java.io.*;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
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
            rowhead.createCell(4).setCellValue("weekday");
            rowhead.createCell(5).setCellValue("startTime");
            rowhead.createCell(6).setCellValue("endTime");
            rowhead.createCell(7).setCellValue("breakDeduction");
            rowhead.createCell(8).setCellValue("totalHour");
            rowhead.createCell(9).setCellValue("note");
            rowhead.createCell(10).setCellValue("status");
            rowhead.createCell(11).setCellValue("createTime");
            rowhead.createCell(12).setCellValue("updateTime");

            double sumWorkingHours = 0;
            Collections.sort(timesheets, new Comparator<Timesheet>() {
                @Override
                public int compare(Timesheet t1, Timesheet t2) {
                    return Long.valueOf(t1.getUser().getUserId()).compareTo(t2.getUser().getUserId());
                }
            });
            long currentUserId = 0;
            for (int i = 0; i < timesheets.size(); i++) {
                HSSFRow row = sheet.createRow((short)i+1);
                row.createCell(0).setCellValue(timesheets.get(i).getTimesheetId());
                row.createCell(1).setCellValue(timesheets.get(i).getContract().getContractName());
                row.createCell(2).setCellValue(timesheets.get(i).getUser().getUserName());
                row.createCell(3).setCellValue(timesheets.get(i).getTimesheetDate().toLocalDate().toString());
                row.createCell(4).setCellValue(timesheets.get(i).getTimesheetDate().toLocalDate().getDayOfWeek().toString());
                row.createCell(5).setCellValue(timesheets.get(i).getStartTime().toLocalTime().toString());
                row.createCell(6).setCellValue(timesheets.get(i).getEndTime().toLocalTime().toString());
                row.createCell(7).setCellValue(timesheets.get(i).getBreakDeduction().toString());
                row.createCell(8).setCellValue(timesheets.get(i).getTotalHour().toString());
                row.createCell(9).setCellValue(timesheets.get(i).getNote());
                row.createCell(10).setCellValue(timesheets.get(i).getStatus());
                row.createCell(11).setCellValue(timesheets.get(i).getCreateTime().toLocalDate().toString());
                row.createCell(12).setCellValue(timesheets.get(i).getUpdateTime().toLocalDate().toString());
                if(i+1 >= timesheets.size() || timesheets.get(i+1).getUser().getUserId() != currentUserId){
                    sheet.getRow(i+1).createCell(13).setCellValue(sumWorkingHours);
                    sumWorkingHours = 0;
                    if(i+1 < timesheets.size()){
                        currentUserId = timesheets.get(i+1).getUser().getUserId();
                    }
                }
                if (timesheets.get(i).getStatus().equals("confirmed")){
                    sumWorkingHours +=  timesheets.get(i).getTotalHour().getHour();
                    sumWorkingHours += (double) timesheets.get(i).getTotalHour().getMinute()/60;
                }
            }

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
