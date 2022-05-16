package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
@AllArgsConstructor
public class HumanResourceProducer {

    private static final Logger LOG = LoggerFactory.getLogger(HumanResourceProducer.class);

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    public void sendMessage(Employee data) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(data);
        LOG.info("json data: {}", json);
        rabbitTemplate.convertAndSend("x.hr", "", json);
    }

}
