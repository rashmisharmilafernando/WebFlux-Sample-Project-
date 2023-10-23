package com.rashi.webfluxproject.handler;

import com.rashi.webfluxproject.dao.CustomerDAO;
import com.rashi.webfluxproject.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDAO customerDAO;

    public Mono<ServerResponse> loadCustomers(ServerRequest request){
        Flux<Customer> customerList=customerDAO.getCustomerList();
        return ServerResponse.ok().body(customerList,Customer.class);
    }

    public Mono<ServerResponse> findCusomter(ServerRequest request){
        int customerId = Integer.valueOf(request.pathVariable("input"));
       // customerDAO.getCustomerList().filter(customer -> customer.getId() ==customerId).take(1).single();
        Mono<Customer> customerMono = customerDAO.getCustomerList().filter(customer -> customer.getId() == customerId).next();
        return ServerResponse.ok().body(customerMono, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest serverRequest){
        Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
        Mono<String> saveCustomer = customerMono.map(customerDAO -> customerDAO.getId() + ":" + customerDAO.getName());
        return ServerResponse.ok().body(saveCustomer, String.class);
    }

}
