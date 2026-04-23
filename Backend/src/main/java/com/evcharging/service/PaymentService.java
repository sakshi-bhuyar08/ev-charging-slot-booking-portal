package com.evcharging.service;

import com.evcharging.model.Payment;
import com.evcharging.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        payment.setPaymentStatus("paid");
        payment.setPaymentDate(LocalDate.now());
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> getPaymentsByBooking(int bookingId) {
        return paymentRepository.findByBookingBookingId(bookingId);
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }
}