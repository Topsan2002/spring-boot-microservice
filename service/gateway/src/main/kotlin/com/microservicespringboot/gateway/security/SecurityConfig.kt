package com.microservicespringboot.gateway.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    @Bean
    fun SecurityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange { exchange ->
                exchange
                    .pathMatchers("/eureka/**")
                    .permitAll() // Allows all requests to paths matching "/eureka/**"
                    .anyExchange()
                    .authenticated()
            } // Requires authentication for any other exchange

            .oauth2ResourceServer { oauth2 -> oauth2.jwt(Customizer.withDefaults()) }
        return http.build()
    }
}