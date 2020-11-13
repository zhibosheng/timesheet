package com.authright.timesheet.service;

import javax.mail.MessagingException;

public interface MessageService {
//    public boolean sendEmail(String TO, String SUBJECT,String BODY_HTML, String BODY_TEXT);
    boolean sendEmail(String RECIPIENT, String SUBJECT, String BODY_HTML, String BODY_TEXT) throws MessagingException;
}
