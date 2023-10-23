package com.rashi.webfluxproject.router;

import com.rashi.webfluxproject.handler.CustomerHandler;
import com.rashi.webfluxproject.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerStreamHandler customerStreamHandler;


    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers",customerHandler::loadCustomers)
                .GET("/router/customers/stream",customerStreamHandler::getCustomer)
                .GET("/router/customer/{input}",customerHandler::findCusomter)
                .POST("/router/customer/save",customerHandler::saveCustomer)

                .build();
    }
}
