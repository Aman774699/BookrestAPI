 package com.API.book.BootRestBook.FileHandler;

 import org.springframework.core.io.ClassPathResource;
 import org.springframework.stereotype.Component;
 import org.springframework.web.multipart.MultipartFile;

 import java.io.File;
 import java.io.FileOutputStream;
 import java.io.InputStream;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.nio.file.StandardCopyOption;

 @Component
 public class FileUploader {
     //    private  final String filepath="D:\\SpringBoot-SelfLearn\\BootRestBook\\src\\main\\resources\\static\\Image";
     private final String filepath = new ClassPathResource("static//Image").getFile().getAbsolutePath();

     FileUploader() throws Exception {

     }

     public boolean isupload(MultipartFile file) {
         boolean yn = false;
         try {
             InputStream byt = file.getInputStream();
             byte size[] = new byte[byt.available()];
             byt.read(size);
             FileOutputStream fos = new FileOutputStream(filepath + File.separator + file.getOriginalFilename());
             fos.write(size);
             fos.flush();
             fos.close();
 //            another way optional way
 //            Files.copy(file.getInputStream(), Paths.get(filepath+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
             yn = true;
         } catch (Exception e) {
             e.printStackTrace();
         }
         return yn;
     }
 }
