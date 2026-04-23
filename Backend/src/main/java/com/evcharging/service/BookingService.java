package com.evcharging.service;

import com.evcharging.model.Booking;
import com.evcharging.model.Slot;
import com.evcharging.repository.BookingRepository;
import com.evcharging.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Transactional
    public Booking createBooking(Booking booking) {
        // Slot DB se fetch karo fresh
        Slot slot = slotRepository.findById(booking.getSlot().getSlotId()).orElse(null);
        
        if (slot == null) {
            throw new RuntimeException("Slot not found!");
        }
        
        if (slot.getAvailabilityStatus().equals("booked")) {
            throw new RuntimeException("Slot already booked!");
        }

        // Slot booked mark karo
        slot.setAvailabilityStatus("booked");
        slotRepository.save(slot);

        // Booking save karo
        booking.setSlot(slot);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUser(int userId) {
        return bookingRepository.findByUserUserId(userId);
    }

    public List<Booking> getBookingsByStation(int stationId) {
        return bookingRepository.findByStationStationId(stationId);
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Transactional
    public Booking cancelBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus("cancelled");
            // Slot wapas available karo
            Slot slot = slotRepository.findById(booking.getSlot().getSlotId()).orElse(null);
            if (slot != null) {
                slot.setAvailabilityStatus("available");
                slotRepository.save(slot);
            }
            return bookingRepository.save(booking);
        }
        return null;
    }
}