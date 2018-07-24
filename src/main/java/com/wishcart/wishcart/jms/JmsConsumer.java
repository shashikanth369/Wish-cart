package com.wishcart.wishcart.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsConsumer {

    @JmsListener(destination = "my-queue")
    public void listener(String message){
        log.error(message);
    }
}
