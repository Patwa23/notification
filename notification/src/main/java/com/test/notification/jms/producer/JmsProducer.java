package com.test.notification.jms.producer;

import com.test.notification.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${notification.activemq.queue}")
    String queue;

    public void send(Task task){
        jmsTemplate.convertAndSend(queue, task);
    }
}
