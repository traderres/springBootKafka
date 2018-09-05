package com.whatever.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by adam on 8/29/18.
 */
@Service
public class MyProducer {
    public static final Logger logger = LoggerFactory.getLogger(MyProducer.class);

    @Autowired
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
