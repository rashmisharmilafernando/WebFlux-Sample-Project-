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
public class CustomerStreamHandler {

    @Autowired
    private CustomerDAO customerDAO;
    public Mono<ServerResponse> getCustomer(ServerRequest request){
        Flux<Customer> customerStream = customerDAO.getCustomerStream();
        return ServerResponse.ok().body(customerStream, Customer.class);
    }
}
