package com.lab.springbootrpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private com.lab.springbootrpc.Service.MQPublisher MQPublisher;

    @GetMapping("/")
    public void demo(){
        MQPublisher.send();
    }
}
