package com.uber.clone.clients;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/9/2024
 */
@FeignClient(name = "servicio-gateway")
public interface GatewayClientRest {

}
