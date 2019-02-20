package com.wishcart.wishcart.domain.customer.web;

import com.wishcart.wishcart.domain.customer.Customer;
import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import com.wishcart.wishcart.domain.customer.service.CustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.OneToOne;

import java.util.List;

import static com.wishcart.wishcart.domain.customer.web.CustomerController.CUSTOMER;

@RestController
@Slf4j
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    public static final String CUSTOMER = "/customer";

    @NonNull
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerEntity> allCustomers(){
        return customerService.getAllCustomers();
    }
}
