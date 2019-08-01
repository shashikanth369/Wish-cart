package com.wishcart.wishcart.domain.customer.service;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.wishcart.wishcart.config.RabbitMqConfig.DEMO_QUEUE;

@Slf4j
@Service
@Data
@RequiredArgsConstructor
public class CustomerService {
    @NonNull
    private CustomerRepository customerRepository;

   @Autowired
   private RabbitTemplate rabbitTemplate;

   @RabbitListener(queues = DEMO_QUEUE)
   private void onMessage(List<CustomerEntity> customers){
       customers.forEach(t -> {
           System.out.println(t.getName());
       });
   }

    public List<CustomerEntity> getAllCustomers()  {
        List<CustomerEntity> customers = customerRepository.findAll();
        rabbitTemplate.convertAndSend(DEMO_QUEUE, customers);
        return customers;
    }
}
