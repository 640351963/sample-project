package com.example.springbootsample.fileStoreSample.client.model;

import lombok.Data;

import java.io.FileInputStream;

@Data
public class DownLoadFile {

    private StorageFileInfo storageFileInfo;

    private FileInputStream fileInputStream;


}
