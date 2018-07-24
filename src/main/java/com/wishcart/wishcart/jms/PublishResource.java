package com.wishcart.wishcart.jms;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Queue;

@RestController
@RequestMapping("/jms")
@RequiredArgsConstructor
public class PublishResource {

    @NonNull
    private Queue queue;

    @NonNull
    private JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String publishMessage(@PathVariable("message") String msg) throws JMSException {
        jmsTemplate.convertAndSend(queue, msg);
        return "published message to queue : " + queue.getQueueName();
    }
}
