package com.course.rabbitmqproducer.entity;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Picture {

    private String name;
    private String type;
    private String source;
    private long size;
}
