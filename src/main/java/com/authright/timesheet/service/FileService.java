package com.authright.timesheet.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.net.URL;

public interface FileService {
    String putObject(MultipartFile file);
    FileOutputStream getObject(String s3Key);
    public URL getObjectUrl(String s3Key);
}
