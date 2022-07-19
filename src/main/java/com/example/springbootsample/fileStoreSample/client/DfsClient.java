package com.example.springbootsample.fileStoreSample.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootsample.fileStoreSample.client.model.StorageFileInfo;
import com.example.springbootsample.fileStoreSample.client.model.StorageFileInfoNode;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Map;

public class DfsClient {

    private static String trackerAddress;

    private static int trackerPort;

    public static void init(String trackerAddress, int trackerPort) {
        trackerAddress = trackerAddress;
        trackerPort = trackerPort;
    }

    public static String upload(File file, Map<String, String> metaData) throws Exception {
        String md5Hex = "";
        long length = file.length();
        String fileName = file.getName();
        String metaDataStr = JSONObject.toJSONString(metaData);
        String dataStr1 = "2#1#" + metaDataStr + "#length+#" + fileName + "#" + metaDataStr;
        Socket connectTrackerSocet = new Socket(trackerAddress, trackerPort);
        OutputStream outputStream = connectTrackerSocet.getOutputStream();
        outputStream.write(dataStr1.getBytes(StandardCharsets.UTF_8));
        connectTrackerSocet.shutdownOutput();
        final InputStream inputStream = connectTrackerSocet.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }
        connectTrackerSocet.shutdownInput();
        connectTrackerSocet.close();
        StorageFileInfo fileInfo = JSON.parseObject(sb.toString(),StorageFileInfo.class);
        final String fileId = fileInfo.getId();
        LinkedList<StorageFileInfoNode> storageNodes = fileInfo.getStorageNodes();
        int total = storageNodes.size();
        int count = 0;
        for (StorageFileInfoNode storageNode : storageNodes) {

        }
        return null;
    }
}
