package com.evcharging.repository;

import com.evcharging.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByBookingBookingId(int bookingId);
    List<Payment> findByPaymentStatus(String status);
}