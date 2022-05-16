package com.course.rabbitmqproducer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RabbitmqQueue {

    private long messages;
    private String name;

    public boolean isDirty() {
        return messages > 0;
    }
}
