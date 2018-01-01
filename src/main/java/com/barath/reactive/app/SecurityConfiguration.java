package com.barath.reactive.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){

        return httpSecurity
                .authorizeExchange()
                    .anyExchange().authenticated().and().formLogin().and()
                .build();

    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService(){

        UserDetails userDetails= User.withDefaultPasswordEncoder()
                    .username("barath")
                    .password("password")
                    .roles("USER")
                    .build();

        return new MapReactiveUserDetailsService(userDetails);
    }
}
