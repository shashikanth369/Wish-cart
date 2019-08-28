package com.wishcart.wishcart.domain.customer.web;

import static com.wishcart.wishcart.domain.customer.web.CustomerController.CUSTOMER;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishcart.wishcart.domain.customer.persistence.CustomerEntity;
import com.wishcart.wishcart.domain.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Slf4j
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
@Api(value = "Customer Resource")
public class CustomerController {

	public static final String CUSTOMER = "/customer";

	@NonNull
	private CustomerService customerService;

	@ApiOperation(value = "Returns all customers")
	@GetMapping("/customers")
	public List<CustomerEntity> allCustomers() {
		return customerService.getAllCustomers();
	}

}
