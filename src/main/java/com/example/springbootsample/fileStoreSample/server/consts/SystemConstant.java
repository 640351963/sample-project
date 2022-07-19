package com.example.springbootsample.fileStoreSample.server.consts;

import java.util.ResourceBundle;

public class SystemConstant {

    public static  String serverRole = null;

    public static  String serverPort = null;

    public static  String trackerAddress = null;

    public static  String heartbeatInterval = null;

    public static  String storageAddress = null;

    public static  String trackerDataPath = null;

    public static  String storageFilePath = null;

    public static  String storageBlockSize = null;

    static {
        ResourceBundle rs = ResourceBundle.getBundle("server");
        serverRole = rs.getString("ctjdfs.role");
        serverPort = rs.getString("ctjdfs.port");
        trackerAddress = rs.getString("ctjdfs.tracker");
        heartbeatInterval = rs.getString("ctjdfs.heartbeat.interval");
        storageAddress = rs.getString("ctjdfs.storage");
        trackerDataPath = rs.getString("ctjdfs.tracker.data.path");
        storageFilePath = rs.getString("ctjdfs.storage.file.path");
        storageBlockSize = rs.getString("ctjdfs.storage.block.size");
    }

}
