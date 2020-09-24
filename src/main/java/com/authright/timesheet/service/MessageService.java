package com.authright.timesheet.service;

public interface MessageService {
    public void sendEmail(String TO, String SUBJECT, String HTMLBODY, String TEXTBODY);
}
