package com.uber.clone.entities;

import com.uber.clone.commons.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date registeredDate;
    private Integer phoneNumber;
    private Integer averageRating;
    private String vehicule;

    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;
}
