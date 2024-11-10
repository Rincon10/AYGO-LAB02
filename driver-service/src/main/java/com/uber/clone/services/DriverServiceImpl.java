package com.uber.clone.services;

import com.uber.clone.commons.enums.DriverStatus;
import com.uber.clone.entities.Driver;
import com.uber.clone.repositories.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository repository;


    @Override
    public Driver updateDriverStatus(Long driverId, DriverStatus driverStatus) {
        Driver driver = getDriverById(driverId);

        driver.setDriverStatus(driverStatus);

        return repository.save(driver);
    }

    @Override
    public Driver getDriverById(Long driverId) {
        Driver driver = repository.findById(driverId)
                .orElseThrow(() -> new NotFoundException("The driver with id" + driverId + " doesnt exists"));
        return driver;
    }

    @Override
    public Driver createNewDriver(Driver driver) {
        Long driverId = driver.getId();
        if (Objects.nonNull(driver) && repository.findById(driverId).isPresent()) {
            throw new RuntimeException("Driver with id " + driverId + " already exists");
        }
        return repository.save(driver);
    }

    @Override
    public List<Driver> getAvailableDrivers(DriverStatus driverStatus) {
        if (!DriverStatus.AVAILABLE.equals(driverStatus)) throw new RuntimeException("Must be an available status");
        List<Driver> availableDrivers = repository.findByDriverStatus(driverStatus.name());
        return availableDrivers;
    }
}
