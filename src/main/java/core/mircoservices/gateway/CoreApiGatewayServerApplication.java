package core.mircoservices.gateway;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CoreApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApiGatewayServerApplication.class, args);
	}

	@Bean
	RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
    		.route(p -> p
			            .path("/my-app/eureka-client/**")
			            .filters(f -> f.rewritePath("/my-app/eureka-client/(?<segment>.*)","/${segment}")
			            				.addResponseHeader("X-Response-Time",new Date().toString()))
			            .uri("lb://EUREKA-CLIENT"))
	        .route(p -> p
		            .path("/my-app/api-gateway-client01/**")
		            .filters(f -> f.rewritePath("/my-app/api-gateway-client01/(?<segment>.*)","/${segment}")
		            				.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://API-GATEWAY-CLIENT01"))
	        .route(p -> p
		            .path("/my-app/api-gateway-client02/**")
		            .filters(f -> f.rewritePath("/my-app/api-gateway-client02/(?<segment>.*)","/${segment}")
		            				.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://API-GATEWAY-CLIENT02"))
	        .build();
	}
	
}
