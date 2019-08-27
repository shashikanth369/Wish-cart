package com.wishcart.wishcart.customertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wishcart.wishcart.config.PersistenceConfig;
import com.wishcart.wishcart.domain.customer.web.CustomerController;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@Import(PersistenceConfig.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void basicTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/customers")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
}
