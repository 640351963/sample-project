package com.example.springbootsample.upload.service;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resources;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {


    void init();

    void sotre(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String fileNam);

    Resources loadAsResources(String fileName);

    void deleteAll();

}
