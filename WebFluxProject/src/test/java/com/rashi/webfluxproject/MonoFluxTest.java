package com.rashi.webfluxproject;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

 /*   @Test
    public void testMono(){

        Mono<String> stringMono= Mono.just("SpringBootWebFlux").log();
        stringMono.subscribe(System.out::println);
    }*/

    @Test
    public void testMono(){

        Mono<?> stringMono= Mono.just("SpringBootWebFlux")
                .then(Mono.error(new RuntimeException("Exception occured..!")))
                .log();
        stringMono.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
   /* @Test
    public void testflux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice");
        fluxString.subscribe(System.out::println);
    }*/

  /*  @Test
    public void testflux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice").log();
        fluxString.subscribe(System.out::println);
    }*/

/*    @Test
    public void testflux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .log();
        fluxString.subscribe(System.out::println);
    }*/

 /*   @Test
    public void testflux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in flux..!")))
                .log();
        fluxString.subscribe(System.out::println);
    }*/

    @Test
    public void testflux(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in flux..!")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println);
    }
}
