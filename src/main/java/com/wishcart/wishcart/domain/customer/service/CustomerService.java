package com.wishcart.wishcart.domain.customer.service;

import com.wishcart.wishcart.domain.address.service.AddressService;
import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Data
public class CustomerService {
   @NonNull
    private CustomerRepository customerRepository;



    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }

}
