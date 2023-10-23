package com.rashi.webfluxproject.dao;

import com.rashi.webfluxproject.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {

    private static void sleepexecution(int i){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public List<Customer> getCustomer(){
       return IntStream.rangeClosed(1,10)
               .peek(CustomerDAO::sleepexecution)
                .peek(i -> System.out.println("Processing count :"+i))
                .mapToObj(i ->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomerStream(){
            return Flux.range(1,10)
                    .delayElements(Duration.ofSeconds(1))
                    .doOnNext(i -> System.out.println("Processing count in stream flow:"+i))
                    .map(i ->new Customer(i,"customer"+i));

    }
}
