package com.wishcart.wishcart.domain.customer.service;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
   @NonNull
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }
}
