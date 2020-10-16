package com.authright.timesheet.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    private String bucket = "timesheet-avatars";
    private String homeDir = System.getProperty("catalina.base") != null ? System.getProperty("catalina.base") : "/tmp/";

    @Autowired
    private AmazonS3 s3client;

    public String putObject(MultipartFile file){
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String s3Key = FilenameUtils.getBaseName(file.getOriginalFilename()) + "_" + UUID.randomUUID() + "." + extension;
        File f = new File(homeDir + s3Key);
        try{
            file.transferTo(f);
            s3client.putObject(bucket,f.getName(),f);
        } catch (IOException e){
            e.printStackTrace();
        }
        return s3Key;
    }

    public FileOutputStream getObject(String s3Key){
        FileOutputStream fos = null;
        try {
            S3Object fullObject = s3client.getObject(new GetObjectRequest(bucket, s3Key));
            S3ObjectInputStream s3is = fullObject.getObjectContent();
            fos = new FileOutputStream(new File(s3Key));
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();
            return fos;
        } catch (Exception e){
            e.printStackTrace();
        }
        return fos;
    }

    public URL getObjectUrl(String s3Key){
        return s3client.getUrl(bucket,s3Key);
    }
}
