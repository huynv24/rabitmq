package com.lab.springbootrpc.Service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQPublisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private String exchange = "rpc-direct-exchange";

    String message = "Hello";

    public void send() {
        System.out.println(" [P] Publisher sent '" + message + "'. Expected response 'Hello World!'");
        String response = (String) amqpTemplate.convertSendAndReceive(exchange, "rpc", message);
        System.out.println(" [P] Publisher got '" + response + "'");
    }
}