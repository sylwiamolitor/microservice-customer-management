package org.sylwia.getawayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer", r -> r.path("/api/v1/customers/**")
                        .uri("lb://CUSTOMER"))
                .route("fraud", r -> r.path("/api/v1/fraud-check/**")
                        .uri("lb://FRAUD"))
                .build();
    }
}