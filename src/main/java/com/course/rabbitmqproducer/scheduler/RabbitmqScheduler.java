package com.course.rabbitmqproducer.scheduler;

import com.course.rabbitmqproducer.client.RabbitmqClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

//@Service
public class RabbitmqScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);

    private RabbitmqClient client;

    public RabbitmqScheduler(RabbitmqClient client) {
        this.client = client;
    }

    @Scheduled(fixedDelay = 90000)
    public void sweepDirtyQueues() {
        try {
            var dirtyqueues = client.getAllQueues().stream().filter(p -> p.isDirty()).collect(Collectors.toList());
            dirtyqueues.forEach(q -> LOG.info("Queue {} has {} unprocessed messages", q.getName(), q.getMessages()));
        } catch (Exception e){
            LOG.warn("Cannot sweep queue: {}", e.getMessage());
        }
    }
}
