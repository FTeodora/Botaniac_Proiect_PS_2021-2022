package com.botaniac.botaniacapigateway;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class BotaniacApiGatewayApplication {
	Logger logger= LoggerFactory.getLogger(BotaniacApiGatewayApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BotaniacApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		logger.info("Routing the gateway...");
		return builder.routes()
				.route("accounts",p -> p.path("/accounts/**")
						.uri("http://localhost:8421/")
						)
				.route("forums",p -> p.path("/forums/**")
						.uri("http://localhost:8422/"))
				.route("plants",p -> p.path("/plants/**")
						.uri("http://localhost:8423/")).
				build();
	}
}
