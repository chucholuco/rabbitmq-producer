package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
@AllArgsConstructor
public class RetryPictureProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger LOG = LoggerFactory.getLogger(RetryPictureProducer.class);



    public void sendMessage(Picture picture) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(picture);
        LOG.info("Message sent is: {}, to x.picture with routing key: {}", picture, picture.getType());
        rabbitTemplate.convertAndSend("x.guideline.work", picture.getType(), json);
    }

}
