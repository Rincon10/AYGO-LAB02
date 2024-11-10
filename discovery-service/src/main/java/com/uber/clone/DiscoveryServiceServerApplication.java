package com.uber.clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/9/2024
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServiceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceServerApplication.class, args);
    }

}
