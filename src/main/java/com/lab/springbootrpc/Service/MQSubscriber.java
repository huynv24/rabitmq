package com.lab.springbootrpc.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MQSubscriber {

    @RabbitListener(queues = "rpc.request")
    public String receive(String msg) {
        System.out.println(" [S] Subscriber received " + msg);
        String response = addWord(msg);
        System.out.println(" [S] Subscriber returned " + response);
        return response;
    }

    public String addWord(String str) {
        return str + " World!";
    }
}
