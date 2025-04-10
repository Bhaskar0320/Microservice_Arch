package config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.reactive.*;
import org.springframework.security.config.web.server.*;
import org.springframework.security.web.server.*;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {

        serverHttpSecurity.
                csrf().disable()
                .authorizeExchange(exchange -> exchange.pathMatchers("/eureka/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

        return serverHttpSecurity.build();

    }
}
