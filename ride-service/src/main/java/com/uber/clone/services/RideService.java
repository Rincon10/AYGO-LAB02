package com.uber.clone.services;

import com.uber.clone.entities.Ride;

public interface RideService {

    Ride updateRideStatusById(Long rideId, String newRideStatus);

    Ride createNewRide(Ride ride);

    Ride getRideById(Long rideId);

}
