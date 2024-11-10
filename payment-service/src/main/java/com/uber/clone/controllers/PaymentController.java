package com.uber.clone.controllers;

import com.uber.clone.entities.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 11/6/2024
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {


    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body((payment));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("INTERNAL_SERVER_ERROR");
        }

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(new ArrayList<>());
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{paymentId}/status")
    public ResponseEntity<?> updatePaymentStatus(@PathVariable Long paymentId, @RequestBody String newPaymentStatus) {
        try {
            return ResponseEntity.ok(newPaymentStatus);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/payments/{paymentId}/refund")
    public ResponseEntity<?> refundPayment(@PathVariable Long paymentId) {
        return ResponseEntity.ok(paymentId);
    }

}
