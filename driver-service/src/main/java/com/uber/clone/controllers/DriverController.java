package com.uber.clone.controllers;

import com.uber.clone.commons.enums.DriverStatus;
import com.uber.clone.entities.Driver;
import com.uber.clone.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<?> createNewDriver(@RequestBody Driver driver) {
        try {
            Driver createdRide = driverService.createNewDriver(driver);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((createdRide));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }
    }

    @GetMapping("/status/available")
    public ResponseEntity<?> getAllAvailableDrivers() {
        try {
            List<Driver> availableDrivers = driverService.getAvailableDrivers(DriverStatus.AVAILABLE);
            return ResponseEntity.ok(availableDrivers);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long driverId, @RequestBody String driverStatus) {
        try {
            Driver driver = driverService.updateDriverStatus(driverId, DriverStatus.valueOf(driverStatus));
            return ResponseEntity.ok(driver);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PatchMapping("/{driverId}/status")
    public ResponseEntity<Driver> updateRideStatus(@PathVariable Long driverId, @RequestBody String driverStatus) {
        try {
            Driver driver = driverService.updateDriverStatus(driverId, DriverStatus.valueOf(driverStatus));
            return ResponseEntity.ok(driver);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
