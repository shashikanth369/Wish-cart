package com.wishcart.wishcart.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;


//@EnableJms
@Configuration
@RequiredArgsConstructor
public class JmsConfig {


/*    @Bean
    public Queue queue(){
        return new ActiveMQQueue("my-queue");
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        //factory.setBrokerURL("tcp://localhost:61616");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(activeMQConnectionFactory());
    }*/
}
