package com.uber.clone.controllers;

import com.uber.clone.entities.Ride;
import com.uber.clone.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@RestController
@RequestMapping("/api/v1/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @PostMapping
    public ResponseEntity<?> createRide(@RequestBody Ride ride) {
        try {
            Ride createdRide = rideService.createNewRide(ride);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((createdRide));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }

    }

    @GetMapping("/{rideId}")
    public ResponseEntity<?> getRideById(@PathVariable Long rideId) {
        try {
            Ride ride = rideService.getRideById(rideId);
            return ResponseEntity.ok(ride);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{rideId}/update-status")
    public ResponseEntity<Ride> assignDriver(@PathVariable Long rideId, @RequestBody String rideStatus) {
        try {
            Ride ride = rideService.updateRideStatusById(rideId, rideStatus);
            return ResponseEntity.ok(ride);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
