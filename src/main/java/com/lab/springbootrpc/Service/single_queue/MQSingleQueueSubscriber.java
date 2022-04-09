package com.lab.springbootrpc.Service.single_queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.lab.springbootrpc.Service.single_queue.MQSingleQueueConfig.*;

@Service
public class MQSingleQueueSubscriber {
    @RabbitListener(queues = {FANOUT_QUEUE_1_NAME})
    public void receiveMessageFanout1(String message) {
        System.out.println(String.format("[%s] [%s] Received message: %s", FANOUT_EXCHANGE_NAME, FANOUT_QUEUE_1_NAME, message));
    }

    @RabbitListener(queues = {FANOUT_QUEUE_2_NAME})
    public void receiveMessageFanout2(String message) {
        System.out.println(String.format("[%s] [%s] Received message: %s", FANOUT_EXCHANGE_NAME, FANOUT_QUEUE_2_NAME, message));
    }

    @RabbitListener(queues = {TOPIC_QUEUE_1_NAME})
    public void receiveMessageTopic1(String message) {
        System.out.println(String.format("[%s] [%s] Received message: %s", TOPIC_EXCHANGE_NAME, TOPIC_QUEUE_1_NAME, message));
    }

    @RabbitListener(queues = {TOPIC_QUEUE_2_NAME})
    public void receiveMessageTopic2(String message) {
        System.out.println(String.format("[%s] [%s] Received message: %s", TOPIC_EXCHANGE_NAME, TOPIC_QUEUE_2_NAME, message));
    }

    @RabbitListener(queues = {HEADERS_QUEUE_NAME})
    public void receiveMessageHeader1(byte[] data) {
        System.out.println(String.format("[%s] [%s] Received message: %s", HEADERS_EXCHANGE_NAME, HEADERS_QUEUE_NAME, new String(data)));
    }
}

