package com.lab.springbootrpc.Service.single_queue;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class MQSingleQueueConfig {

    public static final String TOPIC_EXCHANGE_NAME = "request-topic-exchange";

    public static final String DIRECT_EXCHANGE_NAME = "request-direct-exchange";

    public static final String DEFAULT_EXCHANGE_NAME = "";

    public static final String FANOUT_EXCHANGE_NAME = "request-fanout-exchange";

    public static final String HEADERS_EXCHANGE_NAME = "request-headers-exchange";

    public static final String FANOUT_QUEUE_1_NAME = "fanout.queue-1";

    public static final String FANOUT_QUEUE_2_NAME = "fanout.queue-2";

    public static final String TOPIC_QUEUE_1_NAME = "topic.queue-1";

    public static final String TOPIC_QUEUE_2_NAME = "topic.queue-2";

    public static final String HEADERS_QUEUE_NAME = "header.queue";

    @Bean
    public Declarables fanoutBindings() {
        Queue fanoutQueue1 = new Queue(FANOUT_QUEUE_1_NAME, false);
        Queue fanoutQueue2 = new Queue(FANOUT_QUEUE_2_NAME, false);
        FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE_NAME);
        return new Declarables(
                fanoutQueue1,
                fanoutQueue2,
                fanoutExchange,
                bind(fanoutQueue1).to(fanoutExchange),
                bind(fanoutQueue2).to(fanoutExchange));
    }

    @Bean
    public Declarables topicBindings() {
        Queue topicQueue1 = new Queue(TOPIC_QUEUE_1_NAME, false);
        Queue topicQueue2 = new Queue(TOPIC_QUEUE_2_NAME, false);
        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME);
        return new Declarables(
                topicQueue1,
                topicQueue2,
                topicExchange,
                bind(topicQueue1).to(topicExchange).with("*.important.*"),
                bind(topicQueue2).to(topicExchange).with("#.error")
        );
    }

    @Bean
    public Declarables headerBindings() {
        Queue headerQueue = new Queue(HEADERS_QUEUE_NAME, false);
        HeadersExchange headersExchange = new HeadersExchange(HEADERS_EXCHANGE_NAME);
        return new Declarables(
                headerQueue,
                headersExchange,
                bind(headerQueue).to(headersExchange).where("level").matches("error")
        );
    }

    @Bean
    public Declarables directBingdings() {
        Queue directQueue1 = new Queue(TOPIC_QUEUE_1_NAME, false);
        Queue directQueue2 = new Queue(TOPIC_QUEUE_2_NAME, false);
        DirectExchange directExchange = new DirectExchange(DIRECT_EXCHANGE_NAME);
        return new Declarables(
                directExchange,
                bind(directQueue1).to(directExchange).with("direct.exchange-1"),
                bind(directQueue2).to(directExchange).with("direct.exchange-2")
        );
    }

}

