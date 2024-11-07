package com.uber.clone.services;

import com.uber.clone.commons.enums.RideStatus;
import com.uber.clone.entities.Ride;
import com.uber.clone.repositories.RideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@Slf4j
@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository repository;

    @Override
    public Ride updateRideStatusById(Long rideId, String newRideStatus) {
        Ride ride = getRideById(rideId);
        ride.setRideStatus(RideStatus.valueOf(newRideStatus));

        repository.save(ride);
        log.info("Ride {} updated: {}", rideId, ride);
        return ride;
    }

    @Override
    public Ride createNewRide(Ride ride) {
        Long rideId = ride.getId();
        if (Objects.nonNull(rideId) && repository.findById(rideId).isEmpty()) {
            throw new RuntimeException("Ride with id " + ride.getId() + " already exists");
        }
        return repository.save(ride);
    }

    @Override
    public Ride getRideById(Long rideId) {
        Ride savedRide = repository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride with id " + rideId + " doesnt exists"));

        return savedRide;
    }
}
