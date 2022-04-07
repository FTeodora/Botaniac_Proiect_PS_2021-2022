package com.botaniac.botaniacapigateway;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * The API Gateway. It routes the microservices to a single port.
 */
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
				.route("homepage",p -> p.path("/Homepage/**")
						.uri("http://localhost:8419/"))
				.route("welcome",p -> p.path("/Welcome/**").
						filters(f -> f.addRequestParameter("username", "user"))
						.uri("http://localhost:8419/"))
				.route("components",p -> p.path("/components/**")
						.uri("http://localhost:8419/"))
				.route("accounts",p -> p.path("/accounts/**")
						.uri("http://localhost:8421/"))
				.route("register",p -> p.path("/Register/**")
						.uri("http://localhost:8421/"))
				.route("login",p -> p.path("/Login/**")
						.uri("http://localhost:8421/"))
				.route("forums",p -> p.path("/forums/**")
						.uri("http://localhost:8422/"))
				.route("plants",p -> p.path("/plants/**")
						.uri("http://localhost:8423/")).
				build();
	}
}
