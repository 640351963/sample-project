package com.example.springbootsample.logsample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogSampleServiceImpl implements LogSampleService{

    @Override
    public void log(String logText) {
        log.info("log sampple text {} ",logText);
    }
}
