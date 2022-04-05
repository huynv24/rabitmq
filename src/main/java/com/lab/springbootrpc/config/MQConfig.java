package com.lab.springbootrpc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("rpc-direct-exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("rpc.request", true);
    }

    @Bean
    Binding emailBinding(Queue emailQueue, DirectExchange exchange) {
        return BindingBuilder.bind(emailQueue).to(exchange).with("rpc");
    }

}