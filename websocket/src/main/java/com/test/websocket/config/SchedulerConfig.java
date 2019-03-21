package com.test.websocket.config;

import com.test.websocket.model.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);

    @Autowired
    private SimpMessagingTemplate jmsTemplate;

    @Scheduled(fixedDelay = 3000) // every 3 second
    public void sendAdhocMessages() {
        jmsTemplate.convertAndSend("/notification-topic3/user", new UserResponse("Testing Fixed Delay Scheduler"));
    }
}
