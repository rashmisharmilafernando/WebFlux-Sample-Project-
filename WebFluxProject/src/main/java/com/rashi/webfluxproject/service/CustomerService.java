package com.rashi.webfluxproject.service;

import com.rashi.webfluxproject.dao.CustomerDAO;
import com.rashi.webfluxproject.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public  List<Customer> loadAllCustomer(){
        long start=System.currentTimeMillis();
        List<Customer> customers=customerDAO.getCustomer();
        long end=System.currentTimeMillis();
        System.out.println("Total execution time :"+( end - start));
        return customers;
    }

    public  Flux<Customer> loadAllCustomerStream(){
        long start=System.currentTimeMillis();
        Flux<Customer> customers=customerDAO.getCustomerStream();
        long end=System.currentTimeMillis();
        System.out.println("Total execution time :"+( end - start));
        return customers;
    }
}
