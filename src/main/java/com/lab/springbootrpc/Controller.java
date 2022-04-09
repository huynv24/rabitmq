package com.lab.springbootrpc;

import com.lab.springbootrpc.Service.single_queue.MQSingleQueuePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private com.lab.springbootrpc.Service.MQPublisher MQPublisher;
    @Autowired
    private MQSingleQueuePublisher mqSingleQueuePublisher;


    @GetMapping("/")
    public void demo(){
        MQPublisher.send();
    }

    @GetMapping("/single")
    public void single(){
        mqSingleQueuePublisher.send();
    }
}
