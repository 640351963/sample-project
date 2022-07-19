package com.example.springbootsample.upload.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resources;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public void init() {
        System.out.println("StorageService init");
    }

    @Override
    public void sotre(MultipartFile file) {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String fileNam) {
        return null;
    }

    @Override
    public Resources loadAsResources(String fileName) {
        return null;
    }

    @Override
    public void deleteAll() {
        System.out.println("StorageService deleteAll");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {



        return builder.build();
    }

}
