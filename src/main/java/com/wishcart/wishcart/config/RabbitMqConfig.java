package com.wishcart.wishcart.config;

import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import com.wishcart.wishcart.domain.customer.service.CustomerService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    public static final String DEMO_TOPIC = "demo-topic";
    public static final String DEMO_QUEUE = "demo-queue";
    private static final String ROUTING_KEY = "route_key";

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RabbitProperties properties;

    @Bean
    public TopicExchange demoExchange(){
        return new TopicExchange(DEMO_TOPIC);
    }

    @Bean
    public Queue demoQueue(){
        return new Queue(DEMO_QUEUE);
    }

    @Bean
    public Binding demoBinding(){
        return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public CachingConnectionFactory connectionFactory()
    {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(properties.getHost());
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        connectionFactory.setRequestedHeartBeat(10);
        return connectionFactory;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(CustomerService receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(DEMO_QUEUE);
        container.setMessageListener(listenerAdapter);
        container.setMessageConverter(jsonMessageConverter());
        container.setApplicationContext(context);
        return container;
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setApplicationContext(context);
        factory.setConcurrentConsumers(10);
        factory.setMaxConcurrentConsumers(10);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
