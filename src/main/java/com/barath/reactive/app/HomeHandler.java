package com.barath.reactive.app;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HomeHandler {


    public Mono<ServerResponse> home(ServerRequest request){

        return ServerResponse.ok().body(BodyInserters.fromObject("hello"));
    }

}
