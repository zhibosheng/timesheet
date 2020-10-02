package com.authright.timesheet.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class EncodeServiceImpl implements EncodeService {
    public boolean encodeExcel(){
        String filePath = "./TimeSheets.xls";
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            String base64 = new Base64().encodeBase64String(bytes);

            String destinationPath = "./encodeTimeSheets.xls";

            //decode Base64 String to image
            FileOutputStream fos = new FileOutputStream(destinationPath);
            bytes = new Base64().decodeBase64(base64);
            fos.write(bytes);


            fis.close();
            fos.close();
            return true;
        }catch (Exception ex) {
            System.out.println("Encode fail "
                    + ex.getMessage());
            return false;
        }
    }
}
