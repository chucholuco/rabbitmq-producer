package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Furniture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;


//@Service
@AllArgsConstructor
public class FurnitureProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger LOG = LoggerFactory.getLogger(FurnitureProducer.class);

    public void sendMessage(Furniture furniture) throws JsonProcessingException {
        var messageProperties = new MessageProperties();
        messageProperties.setHeader("color", furniture.getColor());
        messageProperties.setHeader("material", furniture.getMaterial());

        var json = objectMapper.writeValueAsString(furniture);
        var message = new Message(json.getBytes(StandardCharsets.UTF_8), messageProperties);

        rabbitTemplate.send("x.promotion", "", message);
        LOG.info("Message send to x.promotion {}", message);
    }

}
