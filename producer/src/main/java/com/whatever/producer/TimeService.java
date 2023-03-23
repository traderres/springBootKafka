package com.whatever.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class TimeService
{
    private static final Logger logger = LoggerFactory.getLogger(TimeService.class);


    public String getCurrentDateTime()
    {
        String currentTime = Instant.now().toString();
        return currentTime;
    }

}
