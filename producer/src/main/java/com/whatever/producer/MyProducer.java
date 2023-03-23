package com.whatever.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * MyProducer service class
 */
@Service
public class MyProducer {
    public static final Logger logger = LoggerFactory.getLogger(MyProducer.class);

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;   // This is established by the MyProducerConfig class


    public MyProducer()
    {
        logger.debug("ReportsProducer() constructor called>");
    }

    public void send(String topic, String payload)
    {
        logger.debug("send() started  topic={}  payload={}", topic, payload);
        kafkaTemplate.send(topic, payload);
    }
}
