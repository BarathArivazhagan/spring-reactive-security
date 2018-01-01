package com.barath.reactive.app;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Component
public class HomeHandler {


    public Mono<ServerResponse> home(ServerRequest request){

       Mono<String> userName=request.principal().map(Principal::getName).map( name -> "hello "+name);
       return ServerResponse.ok().body(userName,String.class);
    }

}
