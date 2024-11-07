package com.uber.clone.entities;

import com.uber.clone.commons.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long driverId;
    private String pickupLocation;
    private String dropOffLocation;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;
}
