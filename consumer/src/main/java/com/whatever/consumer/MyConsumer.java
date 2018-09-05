package com.whatever.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * ReportsConsumer
 */
@Service
public class MyConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    public MyConsumer()
    {
        logger.debug("ReportsConsumer() constructor called.");
    }

    @KafkaListener(topics = "updates")
    public void receive(String payload) {
        logger.debug("receive()  payload={}", payload);
    }
}
