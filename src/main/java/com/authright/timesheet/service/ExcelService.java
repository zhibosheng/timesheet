package com.authright.timesheet.service;

import com.authright.timesheet.model.Timesheet;

import java.util.List;

public interface ExcelService {
    boolean generateExcel(List<Timesheet> timesheets);
}
