package com.wishcart.wishcart.customertests;

import com.wishcart.wishcart.domain.address.service.AddressService;
import com.wishcart.wishcart.domain.customer.persistence.CustomerRepository;
import com.wishcart.wishcart.domain.customer.service.CustomerService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)

public class customerServiceTests {

    /*@InjectMocks
     CustomerService customerService;
    @Mock
     AddressService addressService;

    @Mock
     CustomerRepository customerRepository;
    List<String> mock = mock(List.class);
    @BeforeEach
    void setup(){

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        when(addressService.someInt()).thenReturn(new ArrayList<>(Arrays.asList(12, 13, 14)));
        customerService.setAddressService(addressService);
        int sum = customerService.sumInt();
        assertEquals(39, sum);

    }
    @Test
    public void  testList(){

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParams(){
            when(mock.get(anyInt())).thenReturn("shashi");
            assertEquals("shashi", mock.get(0));
            assertEquals("shashi", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        String val = mock.get(0);
        String val2 = mock.get(1);
        verify(mock).get(0);
        verify(mock).get(1);
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(10);
    }

    @Test
    public void argCapture(){
        mock.add("shashi");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(argumentCaptor.capture());
        assertEquals("shashi", argumentCaptor.getValue());
    }

    @Test
    public void spying(){
        List arrayListMock = mock(ArrayList.class);

    }*/

}
