package com.example.springbootsample.fileStoreSample.client.model;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Map;

@Data
@ToString
public class StorageFileInfo {


    private String id;
    private String name;
    private Long size;
    private Map<String, String> metadata;
    private LinkedList<StorageFileInfoNode> storageNodes = new LinkedList<>();


}
