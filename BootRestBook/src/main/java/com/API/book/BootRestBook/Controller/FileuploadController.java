package com.API.book.BootRestBook.Controller;

import com.API.book.BootRestBook.FileHandler.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileuploadController {

    @Autowired
    private FileUploader fileUploader;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            boolean isupload = fileUploader.isupload(file);
            if (isupload) {
//                return ResponseEntity.status(HttpStatus.GONE).build();
//                  return ResponseEntity.ok("File Gone");
//                 return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(file.getOriginalFilename()).toString());
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/Image/")
                        .path(file.getOriginalFilename())
                        .build()
                        .toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
