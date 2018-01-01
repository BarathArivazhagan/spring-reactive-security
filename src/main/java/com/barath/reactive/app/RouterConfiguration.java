package com.barath.reactive.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterConfiguration {

    private HomeHandler homeHandler;

    public RouterConfiguration(HomeHandler homeHandler) {
        this.homeHandler=homeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> routes(){

        return RouterFunctions
                .route(RequestPredicates.GET("/home"),homeHandler::home);
    }
}
