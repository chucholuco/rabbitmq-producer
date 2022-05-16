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
public class PictureProducerTwo {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger LOG = LoggerFactory.getLogger(PictureProducerTwo.class);



    public void sendMessage(Picture picture) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(picture);

        var sb = new StringBuilder();
        // 1st word is picture source
        sb.append(picture.getSource());
        sb.append(".");

        // 2sd word is based on picture size
        if (picture.getSize() > 400) {
            sb.append("large");
        } else {
            sb.append("small");
        }
        sb.append(".");

        // 3rd word is picture type
        sb.append(picture.getType());


        LOG.info("Message sent is: {}, to x.picture2 with routing key: {}", json, sb.toString());
        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), json);
    }

}
