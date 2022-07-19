package com.example.springbootsample.upload;

import com.example.springbootsample.upload.service.StorageService;
import com.google.common.io.Resources;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class UploadSampleController {



    private StorageService storageService;
    public UploadSampleController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping("/")
    public  String listUploadFiles(Model model) throws IOException {
        model.addAttribute("files",storageService);
        return "";
    }

    @GetMapping("/files/{filename:.+)")
    @ResponseBody
    public ResponseEntity<Resources> serverFile(@PathVariable String filename){

        final Path load = storageService.load(filename);



        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\""+""
                ).build();
    }









}
