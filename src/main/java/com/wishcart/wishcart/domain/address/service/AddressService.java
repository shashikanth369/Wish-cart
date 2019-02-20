package com.wishcart.wishcart.domain.address.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class AddressService {

public List<Integer> someInt(){
    return new ArrayList<>(Arrays.asList(12, 13));
}
}
