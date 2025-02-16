package org.sylwia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer", r -> r.path("/customer/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://CUSTOMER"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

}