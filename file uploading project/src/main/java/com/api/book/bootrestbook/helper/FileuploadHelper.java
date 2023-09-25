package com.api.book.bootrestbook.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;

@Component
public class FileuploadHelper {
    public final String
            UPLOAD_DIR="C:\\Users\\HP\\OneDrive\\Desktop\\spring\\bootrestbook\\src\\main\\resources\\static";
    public boolean uploadfile(MultipartFile multipartFile)
    {
        boolean f=false;
     try{
         //
//         InputStream is=multipartFile.getInputStream();
//         byte data[]=new byte[is.available()];
//         is.read(data);
//         //write
//         //in the place of slashes// --> u can use file.separator
//         FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//  fos.write(data);
//  fos.flush();
//  fos.close();
         Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
  f=true;
     }catch(Exception e){
         e.printStackTrace();
     }
     return f;
    }

}
