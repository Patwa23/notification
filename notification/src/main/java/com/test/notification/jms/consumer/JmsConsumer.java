package com.test.notification.jms.consumer;

import com.test.notification.model.MessageStorage;
import com.test.notification.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    @Autowired
    private MessageStorage taskStorage;

    @JmsListener(destination = "${notification.activemq.queue}", containerFactory="jsaFactory")
    public void receive(Task task){
        taskStorage.add(task);
    }
}
