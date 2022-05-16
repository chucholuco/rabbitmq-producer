package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitProducer {

    private RabbitTemplate rabbitTemplate;

    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHello(String name) {
        rabbitTemplate.convertAndSend("course.hello", "Hello" + name);
    }
}
