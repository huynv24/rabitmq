package com.lab.springbootrpc.Service.single_queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSingleQueuePublisher {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send() {
        amqpTemplate.convertAndSend(MQSingleQueueConfig.TOPIC_EXCHANGE_NAME, "msg.important.warn",
                "topic important warn: " + "test1");

        amqpTemplate.convertAndSend(MQSingleQueueConfig.TOPIC_EXCHANGE_NAME, "msg.error",
                "topic important error: " + "test2");

    }
}
