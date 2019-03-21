package com.test.notification.config;

import com.test.notification.model.MessageStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public MessageStorage customerStorage() {
        return new MessageStorage();
    }
}
