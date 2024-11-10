package com.uber.clone.services;

import com.uber.clone.commons.enums.DriverStatus;
import com.uber.clone.entities.Driver;

import java.util.List;

public interface DriverService {

    Driver updateDriverStatus(Long driverId, DriverStatus driverStatus);

    Driver getDriverById(Long driverId);

    Driver createNewDriver(Driver driver);

    List<Driver> getAvailableDrivers(DriverStatus driverStatus);

}
