package com.example.playgroundbackend.service.impl;

import com.example.playgroundbackend.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    protected JmsTemplate jmsTemplate;

    @Override
    public void producer(String message) {
        log.info("HelloWorldServiceImpl.producer -> playground-sqs with message: ".concat(message));
        jmsTemplate.convertAndSend("playground-sqs", message);
    }

    @JmsListener(destination = "playground-sqs")
    public void consumer(String message) {
        log.info("HelloWorldServiceImpl.consumer -> playground-sqs with message: ".concat(message));
        System.out.println(message);
    }

}
